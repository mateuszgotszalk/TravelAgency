package com.gotszalk.travelservice.userPackage.controller;

import com.gotszalk.travelservice.userPackage.model.LoginRequest;
import com.gotszalk.travelservice.userPackage.model.RegisterRequest;
import com.gotszalk.travelservice.userPackage.model.User;
import com.gotszalk.travelservice.userPackage.service.IUserService;
import com.gotszalk.travelservice.userPackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "registration")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){

        try {
            User registered = userService.registerNewUser(registerRequest);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
        return ResponseEntity.ok("successfully created account");
    }

    @PostMapping(path = "login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        System.out.println("Login w trakcie....");
        return ResponseEntity.ok("successfully login to account");
    }

    @GetMapping("show")
    public String show(){
        return "user has permit to this endpoint";
    }
}
