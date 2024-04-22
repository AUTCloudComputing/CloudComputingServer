package ac.aut.CloudComputing.bookingsystem.dto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections; 
 
import lombok.Data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Data  
public class UserDetailsDTO implements UserDetails{
 
	private String id;
 
	private String userName; 
	private String email; 
	private String password; 
	private String profileImageS3Key; // Reference to the user's profile image stored in S3
	

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	return Collections.unmodifiableList(Arrays.asList());
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
