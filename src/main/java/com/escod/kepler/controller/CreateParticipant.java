package com.escod.kepler.controller;

import com.escod.kepler.data.CreateParticipantRequest;
import com.escod.kepler.data.ResponseParticipant;
import com.escod.kepler.entity.User;
import com.escod.kepler.entity.activity.Participant;
import com.escod.kepler.exception.CreateUserException;
import io.jmix.core.DataManager;
import io.jmix.core.NoResultException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/participants")
public class CreateParticipant {

  @Autowired
  protected DataManager dataManager;

  @Autowired
  private PasswordEncoder passwordEncoder;

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

    Participant newparticipant = dataManager.create(Participant.class);

    newparticipant.setActive(Boolean.FALSE);
    newparticipant.setUser(newuser);

    dataManager.save(newparticipant);
    return ResponseEntity.ok().body(getResponse(newuser, newparticipant));
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
    String password = newuser.getPassword();
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
