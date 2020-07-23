package com.ironhack.erp.edgeservice.controller.impl;


import com.ironhack.erp.edgeservice.controller.interfaces.AuthenticationControllerInterface;
import com.ironhack.erp.edgeservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationControllerImpl implements AuthenticationControllerInterface {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Authentication login(@AuthenticationPrincipal Authentication authentication){ return authentication;}

    @GetMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public String logout(HttpServletRequest request){ return "Bye bye :D" + request.getLocalName();}
}
