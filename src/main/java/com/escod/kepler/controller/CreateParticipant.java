package com.escod.kepler.controller;

import com.escod.kepler.data.CreateParticipantRequest;
import com.escod.kepler.data.ResponseParticipant;
import com.escod.kepler.entity.User;
import com.escod.kepler.entity.activity.Participant;
import com.escod.kepler.exception.CreateUserException;
import com.escod.kepler.security.rest.roles.TypeRoleAsignation;
import com.escod.kepler.security.rest.roles.UserManagementRole;
import io.jmix.core.DataManager;
import io.jmix.core.NoResultException;
import io.jmix.rest.security.role.RestMinimalRole;
import io.jmix.securitydata.entity.RoleAssignmentEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/participants")
public class CreateParticipant {

  @Autowired
  protected DataManager dataManager;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @GetMapping("findUsername")
  public ResponseEntity<Boolean> getParticipants(@RequestParam String username) {

    Boolean exist;
    try {
      validateUserExist(username);
      exist = Boolean.FALSE;
    } catch (CreateUserException exception) {
      exist = Boolean.TRUE;
    }

    return ResponseEntity.ok(exist);
  }

  @PostMapping("/create")
  public ResponseEntity<ResponseParticipant> createParticipant(@RequestBody @Valid final CreateParticipantRequest createParticipantRequest)
      throws CreateUserException {

    User newuser = dataManager.create(User.class);

    newuser.setUsername(createParticipantRequest.getUsername());
    newuser.setPassword(passwordEncoder.encode(createParticipantRequest.getPassword()));
    newuser.setEmail(createParticipantRequest.getEmail());
    newuser.setFirstName(createParticipantRequest.getName());
    newuser.setLastName(createParticipantRequest.getLastName());
    newuser.setActive(Boolean.FALSE);

    validateUserExist(createParticipantRequest.getUsername());
    dataManager.save(newuser);

    dataManager.saveAll(buildRolesParticipant(newuser, UserManagementRole.CODE, RestMinimalRole.CODE));

    Participant newparticipant = dataManager.create(Participant.class);

    newparticipant.setActive(Boolean.FALSE);
    newparticipant.setUser(newuser);

    dataManager.save(newparticipant);
    return ResponseEntity.ok().body(getResponse(newuser, newparticipant));
  }

  private List<RoleAssignmentEntity> buildRolesParticipant(User user, String... roles) {

    List<RoleAssignmentEntity> roleAssignments = new ArrayList<>();
    for (String role : roles) {
      var roleAssignment = dataManager.create(RoleAssignmentEntity.class);

      roleAssignment.setUsername(user.getUsername());
      roleAssignment.setRoleCode(role);
      roleAssignment.setRoleType(TypeRoleAsignation.RESOURCE.getId());
      roleAssignments.add(roleAssignment);
    }

    return roleAssignments;
  }

  private void validateUserExist(String username) throws CreateUserException {

    try {
      dataManager.load(User.class)
          .query("select u from User u where u.username = :username")
          .parameter("username", username).one();

      throw new CreateUserException(username);
    } catch (NoResultException ignored) {
    }
  }

  private ResponseParticipant getResponse(User newuser, Participant newparticipant) {
    String username = newuser.getUsername();
    String email = newuser.getEmail();
    String firstname = newuser.getFirstName();
    String lastname = newuser.getLastName();
    Boolean active = newparticipant.getActive();

    return new ResponseParticipant(username,
        email,
        firstname,
        lastname,
        active);
  }
}
