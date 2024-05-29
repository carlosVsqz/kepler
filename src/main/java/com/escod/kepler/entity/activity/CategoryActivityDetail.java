package com.escod.kepler.entity.activity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "CATEGORY_ACTIVITY_DETAIL", indexes = {
    @Index(name = "IDX_CATEGORY_ACTIVITY_DETAIL_ACTIVITY", columnList = "ACTIVITY_ID"),
    @Index(name = "IDX_CATEGORY_ACTIVITY_DETAIL_CATEGORY_ACTIVITY", columnList = "CATEGORY_ACTIVITY_ID")
})
@Entity
public class CategoryActivityDetail {
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

  @JoinColumn(name = "ACTIVITY_ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private Activity activity;

  @JoinColumn(name = "CATEGORY_ACTIVITY_ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private CategoryActivity categoryActivity;

  public CategoryActivity getCategoryActivity() {
    return categoryActivity;
  }

  public void setCategoryActivity(CategoryActivity categoryActivity) {
    this.categoryActivity = categoryActivity;
  }

  public Activity getActivity() {
    return activity;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
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