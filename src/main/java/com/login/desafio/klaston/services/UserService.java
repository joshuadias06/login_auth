package com.login.desafio.klaston.services;

import com.login.desafio.klaston.models.User;
import com.login.desafio.klaston.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User user) {
        user.setId((long) (userStore.size() + 1));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userStore.put(user.getId(), user);
        return user;
    }

    public User update(Long id, User user) {
        if (!userStore.containsKey(id)) {
            throw new NoSuchElementException("User not found");
        }
        user.setId(id);
        userStore.put(id, user);
        return user;
    }

    public void delete(Long id) {
        if (!userStore.containsKey(id)) {
            throw new NoSuchElementException("User not found");
        }
        userStore.remove(id);
    }


}
