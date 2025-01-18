package com.login.desafio.klaston.controllers;

import com.login.desafio.klaston.models.User;
import com.login.desafio.klaston.services.UserService;
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

    @PostMapping("/login")
    public String login (@RequestParam String username, @RequestParam String password){
        String sessionId = userService.loginUser(username, password);
        if(sessionId != null){
            return "Login bem sucedido! Session ID: " + sessionId;
        }
        return "Acesso negado! Sessao Invalida";
    }

    @GetMapping("/protected")
    public String protectedEndpoint(@RequestParam String sessionId){
        if(userService.validateSession(sessionId)){
            return "Voce acessou um endpoint protegido!";
        }
        return "Acesso negado! Sessao Invalida";
    }

    @PostMapping("/logout")
    public String logout(@RequestParam String sessionId) {
        userService.logoutUser(sessionId);
        return "Logout bem-sucedido!";
    }
}
