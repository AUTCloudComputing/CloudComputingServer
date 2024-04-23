package ac.aut.CloudComputing.bookingsystem.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.aut.CloudComputing.bookingsystem.dto.LoginResponse;
import ac.aut.CloudComputing.bookingsystem.dto.UserDetailsDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserLoginDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserRegisterDTO;
import ac.aut.CloudComputing.bookingsystem.service.JwtService;
import ac.aut.CloudComputing.bookingsystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Api(tags = "User Management")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ApiOperation("Register a new user")
    public ResponseEntity<LoginResponse> register(@ApiParam("User registration details") @RequestBody UserRegisterDTO registerUserDto) throws IOException {
        LoginResponse r = userService.registerUser(registerUserDto);
        return ResponseEntity.ok(r);
    }

    @PostMapping("/login")
    @ApiOperation("Authenticate user")
    public ResponseEntity<LoginResponse> authenticate(@ApiParam("User login details") @RequestBody UserLoginDTO loginUserDto) {
        LoginResponse r = userService.loginUser(loginUserDto);
        return ResponseEntity.ok(r);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/clear")
    @ApiOperation("Clear all users (for testing)")
    public ResponseEntity<Void> clearUsers() {
        userService.clearUsers();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/me")
    @ApiOperation("Get details of authenticated user")
    public ResponseEntity<UserDetailsDTO> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsDTO currentUser = (UserDetailsDTO) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    @ApiOperation("Get all users")
    public ResponseEntity<List<UserDetailsDTO>> allUsers() {
        List<UserDetailsDTO> users = userService.allUsers();
        return ResponseEntity.ok(users);
    }

}
