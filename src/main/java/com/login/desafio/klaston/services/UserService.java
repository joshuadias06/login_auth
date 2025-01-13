package com.login.desafio.klaston.services;

import com.login.desafio.klaston.models.User;
import com.login.desafio.klaston.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    /*
    * Function -> registerUser
    * Function -> loginUSer
    * Function -> validateSession
    * Function -> logoutUser
    * */

    private final UserRepository userRepository;
    private final Map<String, User> sessionMap = new HashMap<>();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String registerUser(User user){
        if(userRepository.findByUsername(user.getUsername()) != null){
            return "User already exists";
        }
        userRepository.save(user);
        return "User created";
    }

    public String loginUser(String username, String password){
        User user = userRepository.findByUsername(username);
        if(user == null && user.getPassword().equals(password)){
            String sessionId = "SESSION-" + user.getId();
            sessionMap.put(sessionId, user);
            return sessionId;
        }
        return null; //Login Inválido!
    }

    public boolean validateSession(String sessionId){
        return sessionMap.containsKey(sessionId);
    }

    public void logoutUser(String sessionId){
        sessionMap.remove(sessionId);
    }
}
