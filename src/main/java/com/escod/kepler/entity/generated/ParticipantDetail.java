package com.escod.kepler.entity.generated;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "participant_details")
public class ParticipantDetail {
  @Id
  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
  private Participant user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "activity_detail_id")
  private ActivityDetail activityDetail;

  @NotNull
  @Column(name = "is_completed", nullable = false)
  private Boolean isCompleted = false;

  public Participant getUser() {
    return user;
  }

  public void setUser(Participant user) {
    this.user = user;
  }

  public ActivityDetail getActivityDetail() {
    return activityDetail;
  }

  public void setActivityDetail(ActivityDetail activityDetail) {
    this.activityDetail = activityDetail;
  }

  public Boolean getIsCompleted() {
    return isCompleted;
  }

  public void setIsCompleted(Boolean isCompleted) {
    this.isCompleted = isCompleted;
  }

}