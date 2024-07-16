package com.escod.kepler.service.impl;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobErrorCode;
import com.azure.storage.blob.models.BlobStorageException;
import com.azure.storage.blob.sas.BlobSasPermission;
import com.azure.storage.blob.sas.BlobServiceSasSignatureValues;
import com.escod.kepler.service.StorageKeplerService;
import gr.netmechanics.jmix.azurefs.AzureFileStorageProperties;
import io.jmix.core.FileRef;
import io.jmix.core.common.util.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class AzureStorage implements StorageKeplerService {
  private static final Logger log = LoggerFactory.getLogger(AzureStorage.class);

  @Autowired
  private AzureFileStorageProperties properties;

  private final AtomicReference<BlobContainerClient> clientReference = new AtomicReference<>();
  private static final ConcurrentHashMap<FileRef, CachedSasUrl> cache = new ConcurrentHashMap<>();

  private String connectionString;
  private String containerName;

  @Value("${app.kepler.max-age.azure.images}")
  private int maxTimeAge;

  @EventListener
  public void initBlobContainerClient(final ApplicationStartedEvent event) {
    refreshBlobContainerClient();
  }

  private void refreshProperties() {
    this.connectionString = properties.getConnectionString();
    this.containerName = properties.getContainerName();
  }

  void refreshBlobContainerClient() {
    refreshProperties();
    Preconditions.checkNotEmptyString(connectionString, "connectionString must not be empty");
    Preconditions.checkNotEmptyString(containerName, "containerName must not be empty");

    BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
        .connectionString(connectionString)
        .buildClient();

    try {
      clientReference.set(blobServiceClient.createBlobContainer(containerName));

    } catch (BlobStorageException e) {
      // The container may already exist, so don't throw an error
      if (!e.getErrorCode().equals(BlobErrorCode.CONTAINER_ALREADY_EXISTS)) {
        log.warn(e.getErrorCode().toString());

      } else {
        clientReference.set(blobServiceClient.getBlobContainerClient(containerName));
      }
    }
  }


  @Override
  public String getURLPublicPassFromRef(FileRef fileRef) {
    if (fileRef == null) return null;

    try {

      OffsetDateTime now = OffsetDateTime.now();

      CachedSasUrl cachedSasUrl = cache.get(fileRef);
      if (cachedSasUrl != null && cachedSasUrl.expirationTime.isAfter(now)) {
        return cachedSasUrl.url;
      }

      OffsetDateTime expirationTime = now.plusHours(maxTimeAge);
      BlobServiceSasSignatureValues sasValues = new BlobServiceSasSignatureValues(expirationTime, BlobSasPermission.parse("r"));

      BlobClient blobClient = clientReference.get().getBlobClient(fileRef.getPath());

      var url = blobClient.getBlobUrl();
      var token = blobClient.generateSas(sasValues);
      String fullUrl = url + "?" + token;

      cache.put(fileRef, new CachedSasUrl(fullUrl, expirationTime));

      return fullUrl;
    } catch (Exception e) {
      log.error(e.getMessage());
      return null;
    }
  }

  private static class CachedSasUrl {
    String url;
    OffsetDateTime expirationTime;

    CachedSasUrl(String url, OffsetDateTime expirationTime) {
      this.url = url;
      this.expirationTime = expirationTime;
    }
  }
}
