package com.escod.kepler.entity.generated;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "activities")
public class Activity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "activity_id", nullable = false)
  private UUID id;

  @Size(max = 256)
  @NotNull
  @Column(name = "title", nullable = false, length = 256)
  private String title;

  @Size(max = 256)
  @NotNull
  @Column(name = "activity_logo", nullable = false, length = 256)
  private String activityLogo;

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

  @OneToMany(mappedBy = "activity")
  private Set<ActivityDetail> activityDetails = new LinkedHashSet<>();

  @OneToMany(mappedBy = "activity")
  private Set<BadgeParticipant> badgeParticipants = new LinkedHashSet<>();

  @OneToMany(mappedBy = "activity")
  private Set<Participant> participants = new LinkedHashSet<>();

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

  public String getActivityLogo() {
    return activityLogo;
  }

  public void setActivityLogo(String activityLogo) {
    this.activityLogo = activityLogo;
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

  public Set<ActivityDetail> getActivityDetails() {
    return activityDetails;
  }

  public void setActivityDetails(Set<ActivityDetail> activityDetails) {
    this.activityDetails = activityDetails;
  }

  public Set<BadgeParticipant> getBadgeParticipants() {
    return badgeParticipants;
  }

  public void setBadgeParticipants(Set<BadgeParticipant> badgeParticipants) {
    this.badgeParticipants = badgeParticipants;
  }

  public Set<Participant> getParticipants() {
    return participants;
  }

  public void setParticipants(Set<Participant> participants) {
    this.participants = participants;
  }

}