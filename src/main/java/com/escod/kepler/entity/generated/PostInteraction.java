package com.escod.kepler.entity.generated;

import com.escod.kepler.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "post_interactions")
public class PostInteraction {
  @Id
  @Column(name = "interaction_id", nullable = false)
  private UUID id;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "post_id", nullable = false)
  private BlogPost post;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @NotNull
  @Column(name = "likes", nullable = false)
  private Boolean likes = false;

  @NotNull
  @Column(name = "dislikes", nullable = false)
  private Boolean dislikes = false;

  @NotNull
  @Lob
  @Column(name = "comment", nullable = false)
  private String comment;

  @NotNull
  @Column(name = "is_visible", nullable = false)
  private Boolean isVisible = false;

  @NotNull
  @Column(name = "created_at", nullable = false)
  private LocalDate createdAt;

  @NotNull
  @Column(name = "updated_at", nullable = false)
  private LocalDate updatedAt;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public BlogPost getPost() {
    return post;
  }

  public void setPost(BlogPost post) {
    this.post = post;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Boolean getLikes() {
    return likes;
  }

  public void setLikes(Boolean likes) {
    this.likes = likes;
  }

  public Boolean getDislikes() {
    return dislikes;
  }

  public void setDislikes(Boolean dislikes) {
    this.dislikes = dislikes;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Boolean getIsVisible() {
    return isVisible;
  }

  public void setIsVisible(Boolean isVisible) {
    this.isVisible = isVisible;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDate getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDate updatedAt) {
    this.updatedAt = updatedAt;
  }

}