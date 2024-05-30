package com.escod.kepler.security.rest.roles;

import com.escod.kepler.entity.User;
import com.escod.kepler.entity.activity.*;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;

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
}