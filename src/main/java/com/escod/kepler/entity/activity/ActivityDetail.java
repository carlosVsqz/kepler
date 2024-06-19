package com.escod.kepler.entity.activity;

import com.escod.kepler.entity.User;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "ACTIVITY_DETAIL", indexes = {
    @Index(name = "IDX_ACTIVITY_DETAIL_ACTIVITY", columnList = "ACTIVITY_ID"),
    @Index(name = "IDX_ACTIVITY_DETAIL_BADGE", columnList = "BADGE_ID"),
    @Index(name = "IDX_ACTIVITY_DETAIL_USER", columnList = "USER_ID")
})
@Entity
public class ActivityDetail {
  @JmixGeneratedValue
  @Column(name = "ID", nullable = false)
  @Id
  private UUID id;

  @InstanceName
  @Size(max = 255)
  @NotNull
  @Column(name = "title", nullable = false)
  private String title;

  @OneToMany(mappedBy = "activityDetail")
  private List<ParticipantDetail> participantDetails;

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

  @Size(max = 32)
  @NotNull
  @Column(name = "status", nullable = false, length = 32)
  private String status;

  @JoinColumn(name = "ACTIVITY_ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private Activity activity;

  @JoinColumn(name = "BADGE_ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private Badge badge;

  @JoinColumn(name = "USER_ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  public List<ParticipantDetail> getParticipantDetails() {
    return participantDetails;
  }

  public void setParticipantDetails(List<ParticipantDetail> participantDetails) {
    this.participantDetails = participantDetails;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Badge getBadge() {
    return badge;
  }

  public void setBadge(Badge badge) {
    this.badge = badge;
  }

  public Activity getActivity() {
    return activity;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  public Boolean getIsActive() {
    return isActive;
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

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}