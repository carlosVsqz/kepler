package com.escod.kepler.entity.activity;

import io.jmix.core.FileRef;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "ACTIVITY")
@Entity
public class Activity {
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

  @DeletedBy
  @Column(name = "DELETED_BY")
  private String deletedBy;

  @DeletedDate
  @Column(name = "DELETED_DATE")
  private OffsetDateTime deletedDate;

  @NotNull
  @Column(name = "title", nullable = false, length = 256)
  private String title;

  @OneToMany(mappedBy = "activity")
  private List<CategoryActivityDetail> categoryActivityDetails;

  @OneToMany(mappedBy = "activity")
  private List<Participant> participants;

  @Column(name = "activity_logo", length = 1024)
  private FileRef activityLogo;

  @NotNull
  @Lob
  @Column(name = "description", nullable = false)
  private String description;

  @NotNull
  @Lob
  @Column(name = "rules", nullable = false)
  private String rules;

  @NotNull
  @Lob
  @Column(name = "instructions", nullable = false)
  private String instructions;

  @NotNull
  @Column(name = "start_date", nullable = false)
  private LocalDate startDate;

  @NotNull
  @Column(name = "end_date", nullable = false)
  private LocalDate endDate;

  @NotNull
  @Column(name = "is_active", nullable = false)
  private Boolean isActive = false;

  @NotNull
  @Column(name = "status", nullable = false, length = 32)
  private String status;

  @OneToMany(mappedBy = "activity")
  private List<ActivityDetail> details;

  @OneToMany(mappedBy = "activity")
  private List<BadgeParticipant> badgeParticipants;

  public List<CategoryActivityDetail> getCategoryActivityDetails() {
    return categoryActivityDetails;
  }

  public void setCategoryActivityDetails(List<CategoryActivityDetail> categoryActivityDetails) {
    this.categoryActivityDetails = categoryActivityDetails;
  }

  public List<BadgeParticipant> getBadgeParticipants() {
    return badgeParticipants;
  }

  public void setBadgeParticipants(List<BadgeParticipant> badgeParticipants) {
    this.badgeParticipants = badgeParticipants;
  }

  public List<Participant> getParticipants() {
    return participants;
  }

  public void setParticipants(List<Participant> participants) {
    this.participants = participants;
  }

  public List<ActivityDetail> getDetails() {
    return details;
  }

  public void setDetails(List<ActivityDetail> details) {
    this.details = details;
  }

  public void setActivityLogo(FileRef activityLogo) {
    this.activityLogo = activityLogo;
  }

  public FileRef getActivityLogo() {
    return activityLogo;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public OffsetDateTime getDeletedDate() {
    return deletedDate;
  }

  public void setDeletedDate(OffsetDateTime deletedDate) {
    this.deletedDate = deletedDate;
  }

  public String getDeletedBy() {
    return deletedBy;
  }

  public void setDeletedBy(String deletedBy) {
    this.deletedBy = deletedBy;
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRules() {
    return rules;
  }

  public void setRules(String rules) {
    this.rules = rules;
  }

  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}