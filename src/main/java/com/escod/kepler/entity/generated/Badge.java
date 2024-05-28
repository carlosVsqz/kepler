package com.escod.kepler.entity.generated;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "badges")
public class Badge {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "badge_id", nullable = false)
  private UUID id;

  @Size(max = 256)
  @Column(name = "name", length = 256)
  private String name;

  @Lob
  @Column(name = "description")
  private String description;

  @Size(max = 1024)
  @Column(name = "image_url", length = 1024)
  private String imageUrl;

  @Lob
  @Column(name = "criteria")
  private String criteria;

  @Column(name = "is_active")
  private Boolean isActive;

  @OneToMany(mappedBy = "badge")
  private Set<ActivityDetail> activityDetails = new LinkedHashSet<>();

  @OneToMany(mappedBy = "badge")
  private Set<BadgeParticipant> badgeParticipants = new LinkedHashSet<>();

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getCriteria() {
    return criteria;
  }

  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
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

}