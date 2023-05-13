package com.example.pbz_islamic.Controller;

import com.example.pbz_islamic.Model.User;
import com.example.pbz_islamic.Repository.UserRepository;
import com.example.pbz_islamic.Service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostConstruct
    public void initRolesAndUser(){
        service.initRolesAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user){
        return service.registerNewUser(user);
    }
}
