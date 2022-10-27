package com.test.controller;

import com.test.entity.User;
import com.test.model.request.LoginRequest;
import com.test.model.request.SignUpRequest;
import com.test.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Integer> signUp(@RequestBody SignUpRequest signUpRequest) throws NoSuchAlgorithmException {
        User user = userService.getUserByUsername(signUpRequest.getUsername());
        if(user == null) {
            user = userService.saveUser(signUpRequest.getUsername(), signUpRequest.getPassword());
            return ResponseEntity.ok(user.getId());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<> login(@RequestBody LoginRequest loginRequest) {

    }


    //
}
