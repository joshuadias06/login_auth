package com.login.desafio.klaston.services;

import com.login.desafio.klaston.models.User;
import com.login.desafio.klaston.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

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

}
