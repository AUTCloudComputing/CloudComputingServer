package ac.aut.CloudComputing.bookingsystem.service;

import java.io.IOException;

import ac.aut.CloudComputing.bookingsystem.dto.UserLoginDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserRegisterDTO;
import ac.aut.CloudComputing.bookingsystem.model.User;

public interface UserService {
     UserRegisterDTO registerUser(UserRegisterDTO request) throws IOException;
     boolean loginUser(UserLoginDTO request); 
}