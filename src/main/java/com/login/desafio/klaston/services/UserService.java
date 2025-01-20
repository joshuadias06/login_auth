package com.login.desafio.klaston.services;

import com.login.desafio.klaston.models.User;
import com.login.desafio.klaston.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private final Map<Long, User> userStore = new HashMap<>();
    private final PasswordEncoder passwordEncoder;
    
}
