package ac.aut.CloudComputing.bookingsystem.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.aut.CloudComputing.bookingsystem.dto.UserLoginRequest;
import ac.aut.CloudComputing.bookingsystem.dto.UserRegisterRequest;
import ac.aut.CloudComputing.bookingsystem.model.User;
import ac.aut.CloudComputing.bookingsystem.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegisterRequest userRequest) throws IOException {
        User user = userService.registerUser(userRequest);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody UserLoginRequest userLoginRequest) {
        User user = userService.loginUser(userLoginRequest);
        return ResponseEntity.ok(user);
    }
}
