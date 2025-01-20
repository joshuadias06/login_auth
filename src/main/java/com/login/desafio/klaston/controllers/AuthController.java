package com.login.desafio.klaston.controllers;

import com.login.desafio.klaston.models.User;
import com.login.desafio.klaston.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        return userService.registerUser(user);
    }

}
