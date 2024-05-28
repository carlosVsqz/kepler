package com.escod.kepler.entity.generated;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name = "routes")
public class Route {
  @Id
  @Column(name = "route_id", nullable = false)
  private UUID id;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "config_id", nullable = false)
  private SectionConfig config;

  @Size(max = 256)
  @NotNull
  @Column(name = "path", nullable = false, length = 256)
  private String path;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public SectionConfig getConfig() {
    return config;
  }

  public void setConfig(SectionConfig config) {
    this.config = config;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

}