package com.escod.kepler.entity.generated;

import com.escod.kepler.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "activity_details")
public class ActivityDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "activity_detail_id", nullable = false)
  private UUID id;

  @Size(max = 255)
  @NotNull
  @Column(name = "title", nullable = false)
  private String title;

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

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "activity_id", nullable = false)
  private Activity activity;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "modified_by_user_id", nullable = false)
  private User modifiedByUser;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "badge_id", nullable = false)
  private Badge badge;

  @OneToMany(mappedBy = "activityDetail")
  private Set<ParticipantDetail> participantDetails = new LinkedHashSet<>();

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

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Activity getActivity() {
    return activity;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  public User getModifiedByUser() {
    return modifiedByUser;
  }

  public void setModifiedByUser(User modifiedByUser) {
    this.modifiedByUser = modifiedByUser;
  }

  public Badge getBadge() {
    return badge;
  }

  public void setBadge(Badge badge) {
    this.badge = badge;
  }

  public Set<ParticipantDetail> getParticipantDetails() {
    return participantDetails;
  }

  public void setParticipantDetails(Set<ParticipantDetail> participantDetails) {
    this.participantDetails = participantDetails;
  }

}