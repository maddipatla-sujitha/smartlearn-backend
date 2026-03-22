package com.smartlearn.smartlearn.controller;

import com.smartlearn.smartlearn.model.User;
import com.smartlearn.smartlearn.repository.UserRepository;
import com.smartlearn.smartlearn.service.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    // ✅ Register
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        userRepository.save(user);
        return "User Registered Successfully!";
    }

    // ✅ Login
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existingUser = userRepository
                .findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!existingUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtService.generateToken(user.getUsername());
    }
    @GetMapping("/test")
    public String test() {
        return "Working!";
    }
}