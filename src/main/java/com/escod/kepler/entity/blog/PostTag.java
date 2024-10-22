package com.escod.kepler.entity.blog;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.UUID;

@JmixEntity
@Table(name = "POST_TAGS", indexes = {
    @Index(name = "IDX_POST_TAGS_POST", columnList = "POST_ID")
})
@Entity
public class PostTag {

  @JmixGeneratedValue
  @Column(name = "ID", nullable = false)
  @Id
  private UUID id;

  @InstanceName
  @Column(name = "NAME")
  private String name;

  @Column(name = "TAG")
  private String tag;

  @OnDeleteInverse(DeletePolicy.UNLINK)
  @JoinColumn(name = "POST_ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private Post post;

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}