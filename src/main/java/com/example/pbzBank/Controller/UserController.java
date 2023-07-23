package com.example.pbzBank.Controller;

import com.example.pbzBank.Model.User;
import com.example.pbzBank.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
    @Autowired

    private UserService service;

    @PostConstruct
    public void initRoleAndUser() {
        service.initRolesAndUser();
    }

    @PostMapping({"/createNewUser"})
    public User createNewUser(@RequestBody User user) {
        return service.registerNewUser(user);
    }

    @GetMapping({"/getAllCustomers"})

    public Iterable<User> getAllCustomer() {
        return service.getAllUser();
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser() {
        return "This URL Access by User";
    }
}
