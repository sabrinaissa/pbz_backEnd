package com.example.pbz_islamic.Service;

import com.example.pbz_islamic.Model.Role;
import com.example.pbz_islamic.Model.User;
import com.example.pbz_islamic.Repository.RoleRepository;
import com.example.pbz_islamic.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private RoleRepository roleRepository;

    public User registerNewUser(User user) {
        return repository.save(user);
    }

    public void initRolesAndUser() {
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Role for admin");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Role for user");
        roleRepository.save(userRole);


        User adminUser = new User();
        adminUser.setUserFirstName("Admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin");
        adminUser.setUserPassword("admin123");

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        repository.save(adminUser);


        User user = new User();
        user.setUserFirstName("User");
        user.setUserLastName("user");
        user.setUserName("user");
        user.setUserPassword("user123");

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        repository.save(user);


    }


}
