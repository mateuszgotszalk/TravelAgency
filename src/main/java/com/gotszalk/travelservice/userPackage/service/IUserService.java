package com.gotszalk.travelservice.userPackage.service;


import com.gotszalk.travelservice.userPackage.model.RegisterRequest;
import com.gotszalk.travelservice.userPackage.model.User;

public interface IUserService {
    User registerNewUser(RegisterRequest registerRequest);
}
