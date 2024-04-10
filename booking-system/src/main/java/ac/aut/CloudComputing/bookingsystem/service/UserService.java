package ac.aut.CloudComputing.bookingsystem.service;

import java.io.IOException;

import ac.aut.CloudComputing.bookingsystem.dto.UserLoginRequest;
import ac.aut.CloudComputing.bookingsystem.dto.UserRegisterRequest;
import ac.aut.CloudComputing.bookingsystem.model.User;

public interface UserService {
    User registerUser(UserRegisterRequest request) throws IOException;
    User loginUser(UserLoginRequest request); 
}