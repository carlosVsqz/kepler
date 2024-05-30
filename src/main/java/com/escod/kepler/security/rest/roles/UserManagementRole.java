package com.escod.kepler.security.rest.roles;

import com.escod.kepler.entity.User;
import com.escod.kepler.entity.activity.Participant;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "User management", code = UserManagementRole.CODE, scope = "API")
public interface UserManagementRole {

  String CODE = "user-management";

  @EntityAttributePolicy(entityClass = User.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
  @EntityPolicy(entityClass = User.class, actions = EntityPolicyAction.ALL)
  void user();

  @EntityAttributePolicy(entityClass = Participant.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
  @EntityPolicy(entityClass = Participant.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.UPDATE, EntityPolicyAction.READ})
  void participant();
}
