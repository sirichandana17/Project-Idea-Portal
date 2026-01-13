package com.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UserDao;
import com.model.User;
import com.service.EmailService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	
	UserDao userDao;
	@Autowired
	EmailService emailService;

	
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
	    User savedUser = userDao.saveUser(user);
	    emailService.sendEmail(
	        savedUser.getEmail(),
	        "Registration Successful",
	        "Hello " + savedUser.getName() + ",\n\nThank you for registering!"
	    );
	    return savedUser;
	}
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {
	    User user = userDao.getUserByEmail(loginRequest.getEmail());
	    
	    if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
	        // Don't check role from request — just return user's real role
	        return ResponseEntity.ok(user); // includes role
	    } else {
	        return ResponseEntity.status(401).body("Invalid email or password");
	    }
	}




    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> user = userDao.getUserById(id);
        return user.isPresent() ? ResponseEntity.ok(user.get()) :
            ResponseEntity.status(404).body("User not found with ID: " + id);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Optional<User> user = userDao.getUserById(id);
        if (user.isPresent()) {
            userDao.deleteUser(id);
            return ResponseEntity.ok("User deleted with ID: " + id);
        } else {
            return ResponseEntity.status(404).body("User not found with ID: " + id);
        }
    }

    @GetMapping("/byEmail/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userDao.getUserByEmail(email);
    }
    

}