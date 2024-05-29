package com.escod.kepler.entity.activity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "CATEGORY_ACTIVITY")
@Entity
public class CategoryActivity {
  @JmixGeneratedValue
  @Column(name = "ID", nullable = false)
  @Id
  private UUID id;

  @CreatedBy
  @Column(name = "CREATED_BY")
  private String createdBy;

  @CreatedDate
  @Column(name = "CREATED_DATE")
  private OffsetDateTime createdDate;

  @LastModifiedBy
  @Column(name = "LAST_MODIFIED_BY")
  private String lastModifiedBy;

  @LastModifiedDate
  @Column(name = "LAST_MODIFIED_DATE")
  private OffsetDateTime lastModifiedDate;

  @OneToMany(mappedBy = "categoryActivity")
  private List<CategoryActivityDetail> categoryActivityDetails;

  @NotNull
  @InstanceName
  @Column(name = "DESCRIPTION", nullable = false)
  private String description;

  @Column(name = "ACTIVE", nullable = false)
  @NotNull
  private Boolean active = false;

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<CategoryActivityDetail> getCategoryActivityDetails() {
    return categoryActivityDetails;
  }

  public void setCategoryActivityDetails(List<CategoryActivityDetail> categoryActivityDetails) {
    this.categoryActivityDetails = categoryActivityDetails;
  }

  public OffsetDateTime getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(OffsetDateTime lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public String getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
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

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}