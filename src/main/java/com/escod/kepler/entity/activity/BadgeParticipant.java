package com.escod.kepler.entity.activity;

import com.escod.kepler.entity.User;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "BADGE_PARTICIPANT", indexes = {
    @Index(name = "IDX_BADGE_PARTICIPANT_ACTIVITY", columnList = "ACTIVITY_ID"),
    @Index(name = "IDX_BADGE_PARTICIPANT_BADGE", columnList = "BADGE_ID"),
    @Index(name = "IDX_BADGE_PARTICIPANT_USER", columnList = "USER_ID")
})
@Entity
public class BadgeParticipant {
  @JmixGeneratedValue
  @Column(name = "ID", nullable = false)
  @Id
  private UUID id;

  @JoinColumn(name = "ACTIVITY_ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private Activity activity;

  @JoinColumn(name = "BADGE_ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private Badge badge;

  @JoinColumn(name = "USER_ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  @Column(name = "DATE_OBTAINED")
  @Temporal(TemporalType.DATE)
  private Date dateObtained;

  public Date getDateObtained() {
    return dateObtained;
  }

  public void setDateObtained(Date dateObtained) {
    this.dateObtained = dateObtained;
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

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}