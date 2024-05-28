package com.escod.kepler.entity.generated;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "section_configs")
public class SectionConfig {
  @Id
  @Column(name = "config_id", nullable = false)
  private UUID id;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "section_id", nullable = false)
  private Section section;

  @NotNull
  @Column(name = "created_at", nullable = false)
  private LocalDate createdAt;

  @NotNull
  @Column(name = "updated_at", nullable = false)
  private LocalDate updatedAt;
  @OneToMany(mappedBy = "config")
  private Set<Route> routes = new LinkedHashSet<>();

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Section getSection() {
    return section;
  }

  public void setSection(Section section) {
    this.section = section;
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

  public Set<Route> getRoutes() {
    return routes;
  }

  public void setRoutes(Set<Route> routes) {
    this.routes = routes;
  }

/*
 TODO [Reverse Engineering] create field to map the 'json_config' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "json_config", columnDefinition = "json not null")
    private Object jsonConfig;
*/
}