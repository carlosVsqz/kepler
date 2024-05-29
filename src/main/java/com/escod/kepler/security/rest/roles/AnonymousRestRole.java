package com.escod.kepler.security.rest.roles;

import com.escod.kepler.entity.activity.Activity;
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
      actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
  void activity();
}