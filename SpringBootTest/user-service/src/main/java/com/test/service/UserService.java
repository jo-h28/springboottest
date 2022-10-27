package com.test.service;

import com.test.entity.User;
import com.test.repository.UserRepository;
import com.test.util.Utility;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username).orElse(null);
    }

    public User saveUser(String username, String password) throws NoSuchAlgorithmException {
        User user = new User();
        user.setUsername(username);
        String hashed = Utility.hashString(password);
        user.setPassword(hashed);
        return userRepository.save(user);
    }

    public User validateUser(String username, String password) throws Exception {
        User user = userRepository.findUserByUsername(username).orElse(null);
        if(user == null) {
            throw new Exception();
        }

    }
}
