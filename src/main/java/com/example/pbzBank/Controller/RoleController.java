package com.example.pbzBank.Controller;

import com.example.pbzBank.Model.Role;
import com.example.pbzBank.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private RoleService service;

    @PostMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role) {
        return service.createNewRole(role);
    }
}
