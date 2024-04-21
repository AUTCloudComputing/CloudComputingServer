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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
 
@RestController
@RequestMapping("/api/users")
@Api(tags = "User Controller", description = "Endpoints for user registration and login")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
 
    @ApiOperation(value = "Register a new user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully registered user"),
            @ApiResponse(code = 400, message = "Bad request") })
    @PostMapping("/register")
    public ResponseEntity<UserRegisterDTO> registerUser(@RequestBody UserRegisterDTO userRequest) throws IOException {
    	UserRegisterDTO user = userService.registerUser(userRequest);
        return ResponseEntity.ok(user);
    }

    @ApiOperation(value = "Login with user credentials")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully logged in"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") })
    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody UserLoginDTO userLoginRequest) {
    	boolean b = userService.loginUser(userLoginRequest);
        return ResponseEntity.ok(b);
    }
}
