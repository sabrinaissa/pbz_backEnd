package com.example.pbz_islamic.Service;

import com.example.pbz_islamic.Model.Role;
import com.example.pbz_islamic.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public Role createNewRole(Role role){
        return repository.save(role);
    }
}
