package ac.aut.CloudComputing.bookingsystem.dto;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ac.aut.CloudComputing.bookingsystem.service.GrantedAuthoritySerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Data  
@Schema
public class UserDetailsDTO implements UserDetails{
 
	@Schema(description = "The unique identifier of the user")
	private String id;
	
	@Schema(description = "The username of the user")
	private String userName;

	@Schema(description = "The email address of the user")
	private String email;
	
	@Schema(description = "The role of the user")
	private String role;
	 
	
	@Schema(description = "The password of the user")
	private String password;
	
	@Schema(description = "The S3 key of the user's profile image")
	private String profileImageS3Key; // Reference to the user's profile image stored in S3
	
	@Schema(description = "The status of the user", example = "1")
	private int status;


    @Override
    @JsonIgnore //If the authorities field is not necessary for the OrderDTO, we can simply ignore it during serialization.
//    @JsonSerialize(contentUsing = GrantedAuthoritySerializer.class)
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // 角色集合
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 角色必须以`ROLE_`开头，数据库中没有，则在这里加
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
    	return authorities;
    }
//
//    public String getPassword() {
//        return password;
//    }

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
