package com.escod.kepler.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/rest/logout-app")
public class LogoutController {

  @GetMapping
  public void logout(
      @RequestParam(name = "post_logout_redirect_uri", required = false) String redirectUri,
      HttpServletRequest request,
      HttpServletResponse response) throws IOException {

    HttpSession session = request.getSession(false);
    if (session != null) {
      session.invalidate();
    }

    if (redirectUri != null && !redirectUri.isEmpty()) {
      response.sendRedirect(redirectUri);
    } else {
      response.sendRedirect("/as-login");
    }
  }
}
