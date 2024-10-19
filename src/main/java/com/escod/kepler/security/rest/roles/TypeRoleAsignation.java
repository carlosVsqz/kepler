package com.escod.kepler.security.rest.roles;

import io.jmix.core.metamodel.datatype.EnumClass;
import org.springframework.lang.Nullable;


public enum TypeRoleAsignation implements EnumClass<String> {

  RESOURCE("resource");

  private final String id;

  TypeRoleAsignation(String id) {
    this.id = id;
  }

  @Override
  public String getId() {
    return id;
  }

  @Nullable
  public static TypeRoleAsignation fromId(String id) {
    for (TypeRoleAsignation at : TypeRoleAsignation.values()) {
      if (at.getId().equals(id)) {
        return at;
      }
    }
    return null;
  }
}