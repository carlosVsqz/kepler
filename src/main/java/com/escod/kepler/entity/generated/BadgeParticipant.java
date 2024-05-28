package com.escod.kepler.entity.generated;

import com.escod.kepler.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "badge_participants")
public class BadgeParticipant {
  @Id
  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "activity_id", nullable = false)
  private Activity activity;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "badge_id", nullable = false)
  private Badge badge;

  @NotNull
  @Column(name = "obtained_at", nullable = false)
  private LocalDate obtainedAt;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Activity getActivity() {
    return activity;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  public Badge getBadge() {
    return badge;
  }

  public void setBadge(Badge badge) {
    this.badge = badge;
  }

  public LocalDate getObtainedAt() {
    return obtainedAt;
  }

  public void setObtainedAt(LocalDate obtainedAt) {
    this.obtainedAt = obtainedAt;
  }

}