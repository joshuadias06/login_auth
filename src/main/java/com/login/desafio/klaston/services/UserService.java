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

    

}
