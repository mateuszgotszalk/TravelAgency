package com.gotszalk.travelservice.userPackage.service;

import com.gotszalk.travelservice.userPackage.model.RegisterRequest;
import com.gotszalk.travelservice.userPackage.model.User;
import com.gotszalk.travelservice.userPackage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class UserService implements IUserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public User registerNewUser(RegisterRequest registerRequest) throws RuntimeException{

        if(emailExist(registerRequest.getEmail())){
            throw new RuntimeException("Account with email: " + registerRequest.getEmail() + " already exist");
        }
        if(usernameExist(registerRequest.getUsername())){
            throw new RuntimeException("Account with username: " + registerRequest.getUsername() + " already exist");
        }
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setFirstname(registerRequest.getFirstName());
        user.setSurname(registerRequest.getSurname());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRoles(Arrays.asList("ROLE_USER"));
        return userRepository.save(user);
    }

    private boolean emailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    private boolean usernameExist(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
