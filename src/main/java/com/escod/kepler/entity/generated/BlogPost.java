package com.escod.kepler.entity.generated;

import com.escod.kepler.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "blog_posts")
public class BlogPost {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "post_id", nullable = false)
  private UUID id;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "category_id", nullable = false)
  private Category category;

  @NotNull
  @Lob
  @Column(name = "post_data", nullable = false)
  private String postData;

  @NotNull
  @Column(name = "total_likes", nullable = false)
  private UUID totalLikes;

  @NotNull
  @Column(name = "total_dislikes", nullable = false)
  private UUID totalDislikes;

  @NotNull
  @Column(name = "is_published", nullable = false)
  private Boolean isPublished = false;

  @NotNull
  @Column(name = "published_at", nullable = false)
  private LocalDate publishedAt;

  @NotNull
  @Column(name = "created_at", nullable = false)
  private LocalDate createdAt;

  @NotNull
  @Column(name = "updated_at", nullable = false)
  private LocalDate updatedAt;

  @OneToMany(mappedBy = "post")
  private Set<PostInteraction> postInteractions = new LinkedHashSet<>();

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public String getPostData() {
    return postData;
  }

  public void setPostData(String postData) {
    this.postData = postData;
  }

  public UUID getTotalLikes() {
    return totalLikes;
  }

  public void setTotalLikes(UUID totalLikes) {
    this.totalLikes = totalLikes;
  }

  public UUID getTotalDislikes() {
    return totalDislikes;
  }

  public void setTotalDislikes(UUID totalDislikes) {
    this.totalDislikes = totalDislikes;
  }

  public Boolean getIsPublished() {
    return isPublished;
  }

  public void setIsPublished(Boolean isPublished) {
    this.isPublished = isPublished;
  }

  public LocalDate getPublishedAt() {
    return publishedAt;
  }

  public void setPublishedAt(LocalDate publishedAt) {
    this.publishedAt = publishedAt;
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

  public Set<PostInteraction> getPostInteractions() {
    return postInteractions;
  }

  public void setPostInteractions(Set<PostInteraction> postInteractions) {
    this.postInteractions = postInteractions;
  }

}