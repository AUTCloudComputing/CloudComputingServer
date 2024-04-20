package ac.aut.CloudComputing.bookingsystem.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.aut.CloudComputing.bookingsystem.dto.UserLoginDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserRegisterDTO;
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
    public ResponseEntity<UserRegisterDTO> registerUser(@RequestBody UserRegisterDTO userRequest) throws IOException {
    	UserRegisterDTO user = userService.registerUser(userRequest);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody UserLoginDTO userLoginRequest) {
    	boolean b = userService.loginUser(userLoginRequest);
        return ResponseEntity.ok(b);
    }
}
