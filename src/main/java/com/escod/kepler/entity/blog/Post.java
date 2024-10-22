package com.escod.kepler.entity.blog;

import io.jmix.core.DeletePolicy;
import io.jmix.core.FileRef;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "POST", indexes = {
    @Index(name = "IDX_POST_UNQ", columnList = "ID", unique = true)
})
@Entity
public class Post {
  @JmixGeneratedValue
  @Column(name = "ID", nullable = false)
  @Id
  private UUID id;

  @OneToMany(mappedBy = "post")
  private List<PostTag> tags;

  @Column(name = "VERSION", nullable = false)
  @Version
  private Integer version;

  @CreatedBy
  @Column(name = "CREATED_BY")
  private String createdBy;

  @CreatedDate
  @Column(name = "CREATED_DATE")
  private OffsetDateTime createdDate;

  @InstanceName
  @Column(name = "NAME")
  private String name;

  @Column(name = "TITLE")
  private String title;

  @Column(name = "image_url", length = 1024)
  private FileRef image;

  @Lob
  @Column(name = "HTML_CONTENT")
  private String htmlContent;

  @JoinTable(name = "POST_POST_LINK",
      joinColumns = @JoinColumn(name = "POST_1_ID"),
      inverseJoinColumns = @JoinColumn(name = "POST_2_ID"))
  @ManyToMany
  private List<Post> relatedPosts;

  @OnDeleteInverse(DeletePolicy.UNLINK)
  @JoinColumn(name = "POST_CATEGORY_ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private PostCategory category;

  public List<Post> getRelatedPosts() {
    return relatedPosts;
  }

  public void setRelatedPosts(List<Post> relatedPosts) {
    this.relatedPosts = relatedPosts;
  }

  public List<PostTag> getTags() {
    return tags;
  }

  public void setTags(List<PostTag> tags) {
    this.tags = tags;
  }

  public OffsetDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(OffsetDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getHtmlContent() {
    return htmlContent;
  }

  public void setHtmlContent(String htmlContent) {
    this.htmlContent = htmlContent;
  }

  public PostCategory getCategory() {
    return category;
  }

  public void setCategory(PostCategory category) {
    this.category = category;
  }

  public FileRef getImage() {
    return image;
  }

  public void setImage(FileRef image) {
    this.image = image;
  }
}