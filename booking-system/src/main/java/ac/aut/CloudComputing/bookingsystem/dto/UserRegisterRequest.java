package ac.aut.CloudComputing.bookingsystem.dto;

import org.springframework.web.multipart.MultipartFile;

public class UserRegisterRequest {
    private String username;
    private String password;
    private String email;
    private MultipartFile profileImage; // Use appropriate type for file upload

    // Constructors
    public UserRegisterRequest() {
    }

    public UserRegisterRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email; 
        
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public MultipartFile getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(MultipartFile profileImage) {
		this.profileImage = profileImage;
	}
}


