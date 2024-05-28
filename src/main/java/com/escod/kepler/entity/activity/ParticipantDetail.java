package com.escod.kepler.entity.activity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.UUID;

@JmixEntity
@Table(name = "PARTICIPANT_DETAIL", indexes = {
    @Index(name = "IDX_PARTICIPANT_DETAIL_ACTIVITY_DETAIL", columnList = "ACTIVITY_DETAIL_ID"),
    @Index(name = "IDX_PARTICIPANT_DETAIL_PARTICIPANT", columnList = "PARTICIPANT_ID")
})
@Entity
public class ParticipantDetail {
  @JmixGeneratedValue
  @Column(name = "ID", nullable = false)
  @Id
  private UUID id;
  @JoinColumn(name = "ACTIVITY_DETAIL_ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private ActivityDetail activityDetail;
  @JoinColumn(name = "PARTICIPANT_ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private Participant participant;

  public Participant getParticipant() {
    return participant;
  }

  public void setParticipant(Participant participant) {
    this.participant = participant;
  }

  public ActivityDetail getActivityDetail() {
    return activityDetail;
  }

  public void setActivityDetail(ActivityDetail activityDetail) {
    this.activityDetail = activityDetail;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}