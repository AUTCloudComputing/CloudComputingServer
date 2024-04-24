package ac.aut.CloudComputing.bookingsystem.exceptions;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	  @ExceptionHandler(BadCredentialsException.class)
	  
	  @ResponseStatus(HttpStatus.UNAUTHORIZED) public String
	  handleBadCredentialsException(BadCredentialsException exception) { return
	  "The username or password is incorrect"; }
	  
	  @ExceptionHandler(AccountStatusException.class)
	  
	  @ResponseStatus(HttpStatus.FORBIDDEN) public String
	  handleAccountStatusException(AccountStatusException exception) { return
	  "The account is locked"; }
	  
	  @ExceptionHandler(AccessDeniedException.class)
	  
	  @ResponseStatus(HttpStatus.FORBIDDEN) public String
	  handleAccessDeniedException(AccessDeniedException exception) { return
	  "You are not authorized to access this resource"; }
	  
	  @ExceptionHandler(SignatureException.class)
	  
	  @ResponseStatus(HttpStatus.FORBIDDEN) public String
	  handleSignatureException(SignatureException exception) { return
	  "The JWT signature is invalid"; }
	  
	  @ExceptionHandler(ExpiredJwtException.class)
	  
	  @ResponseStatus(HttpStatus.FORBIDDEN) public String
	  handleExpiredJwtException(ExpiredJwtException exception) { return
	  "The JWT token has expired"; }
	  
	  @ExceptionHandler(Exception.class)
	  
	  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) public String
	  handleException(Exception exception) { return
	  "Unknown internal server error:" + exception.getMessage(); }
	 
}
