package com.codingdojo.loginandregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
    
import com.codingdojo.loginandregistration.models.Login;
import com.codingdojo.loginandregistration.models.User;
import com.codingdojo.loginandregistration.repositories.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
  
  //Registration validations and errors  
    public User register(User newUser, BindingResult result) {
    	
    	Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());
    	
    	if(potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "An account with that email already exists!");
    	}

    	if(!newUser.getPassword().equals(newUser.getConfirmpw())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}

        if(result.hasErrors()) {
        	return null;
        }
    
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return userRepository.save(newUser);
    }

    // Login validations and errors
    public User login(Login newLogin, BindingResult result) {
        // TO-DO - Reject values:
        
    	Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
    	
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "User not found!");
    		return null;
    	}
    	
    	User user = potentialUser.get();
        
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
    	if(result.hasErrors()) {
        	return null;
        }

    	return user;
    }
    
    public User findById(Long id) {
    	Optional<User> potentialUser = userRepository.findById(id);
    	if(potentialUser.isPresent()) {
    		return potentialUser.get();
    	}
    	return null;
    }

}