package com.Exam.UserName.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Exam.UserName.Entity.User;
import com.Exam.UserName.Repository.UserRepo;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public User createUser(@RequestBody User user) {
        // Generate password
        String password = generatePassword(user.getFirstName(), user.getMiddleName(), user.getLastName());
        user.setPassword(password);

        // Save user to the database
        return userRepo.save(user);
    }

    // Method to generate password
    private String generatePassword(String firstName, String middleName, String lastName) {
        // Extract two characters from each name and concatenate with a 3-digit random number
        String password = firstName.substring(0, 2) +
                          middleName.substring(0, 2) +
                          lastName.substring(0, 2) +
                          String.format("%03d", (int) (Math.random() * 1000));
        return password;
    }
}

