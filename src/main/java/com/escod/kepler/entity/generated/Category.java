package com.escod.kepler.entity.generated;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "category_id", nullable = false)
  private UUID id;

  @Size(max = 128)
  @NotNull
  @Column(name = "description", nullable = false, length = 128)
  private String description;

  @NotNull
  @Column(name = "is_active", nullable = false)
  private Boolean isActive = false;

  @NotNull
  @Column(name = "created_at", nullable = false)
  private LocalDate createdAt;

  @NotNull
  @Column(name = "updated_at", nullable = false)
  private LocalDate updatedAt;

  @OneToMany(mappedBy = "category")
  private Set<BlogPost> blogPosts = new LinkedHashSet<>();

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
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

  public Set<BlogPost> getBlogPosts() {
    return blogPosts;
  }

  public void setBlogPosts(Set<BlogPost> blogPosts) {
    this.blogPosts = blogPosts;
  }

}