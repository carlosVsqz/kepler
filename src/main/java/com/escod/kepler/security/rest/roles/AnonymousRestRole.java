package com.escod.kepler.security.rest.roles;

import com.escod.kepler.entity.cms.CMSSite;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "AnonymousRestRole", code = AnonymousRestRole.CODE, scope = "API")
public interface AnonymousRestRole {

  String CODE = "anonymous-rest-role";

  @EntityAttributePolicy(entityClass = CMSSite.class,
      attributes = "*",
      action = EntityAttributePolicyAction.MODIFY)
  @EntityPolicy(entityClass = CMSSite.class,
      actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
  void cmsSite();
}