package com.escod.kepler.security.rest.roles;

import com.escod.kepler.entity.User;
import com.escod.kepler.entity.activity.*;
import com.escod.kepler.entity.blog.Post;
import com.escod.kepler.entity.blog.PostCategory;
import com.escod.kepler.entity.blog.PostTag;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securitydata.entity.RoleAssignmentEntity;

@ResourceRole(name = "AnonymousRestRole", code = AnonymousRestRole.CODE, scope = "API")
public interface AnonymousRestRole {

  String CODE = "anonymous-rest-role";

  @EntityAttributePolicy(entityClass = Activity.class,
      attributes = "*",
      action = EntityAttributePolicyAction.VIEW)
  @EntityPolicy(entityClass = Activity.class,
      actions = {EntityPolicyAction.READ})
  void activity();

  @EntityAttributePolicy(entityClass = CategoryActivityDetail.class,
      attributes = "*",
      action = EntityAttributePolicyAction.VIEW)
  @EntityPolicy(entityClass = CategoryActivityDetail.class,
      actions = {EntityPolicyAction.READ})
  void activityCategoryDetail();

  @EntityAttributePolicy(entityClass = Participant.class,
      attributes = "*",
      action = EntityAttributePolicyAction.VIEW)
  @EntityPolicy(entityClass = Participant.class,
      actions = {EntityPolicyAction.READ})
  void participant();

  @EntityAttributePolicy(entityClass = ActivityDetail.class,
      attributes = "*",
      action = EntityAttributePolicyAction.VIEW)
  @EntityPolicy(entityClass = ActivityDetail.class,
      actions = {EntityPolicyAction.READ})
  void activityDetail();

  @EntityAttributePolicy(entityClass = BadgeParticipant.class,
      attributes = "*",
      action = EntityAttributePolicyAction.VIEW)
  @EntityPolicy(entityClass = BadgeParticipant.class,
      actions = {EntityPolicyAction.READ})
  void badgeParticipant();

  @EntityPolicy(entityClass = User.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ})
  void user();

  @EntityAttributePolicy(entityClass = Participant.class, attributes = "user", action = EntityAttributePolicyAction.VIEW)
  @EntityPolicy(entityClass = Participant.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.UPDATE, EntityPolicyAction.READ})
  void participantCreate();

  @EntityPolicy(entityClass = RoleAssignmentEntity.class, actions = {EntityPolicyAction.CREATE})
  void policyActionCreate();

  //  blog read permissions
  @EntityAttributePolicy(entityClass = Post.class,
      attributes = "*",
      action = EntityAttributePolicyAction.VIEW)
  @EntityPolicy(entityClass = Post.class, actions = {EntityPolicyAction.READ})
  void getPosts();

  @EntityAttributePolicy(entityClass = PostCategory.class,
      attributes = "*",
      action = EntityAttributePolicyAction.VIEW)
  @EntityPolicy(entityClass = PostCategory.class, actions = {EntityPolicyAction.READ})
  void getPostCategories();

  @EntityAttributePolicy(entityClass = PostTag.class,
      attributes = "*",
      action = EntityAttributePolicyAction.VIEW)
  @EntityPolicy(entityClass = PostTag.class, actions = {EntityPolicyAction.READ})
  void getPostTags();
}