package com.example.pbzBank.Service;
import com.example.pbzBank.Model.Role;
import com.example.pbzBank.Model.Staff;
import com.example.pbzBank.Model.User;
import com.example.pbzBank.Repository.RoleRepository;
import com.example.pbzBank.Repository.StaffRepository;
import com.example.pbzBank.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired

    private RoleRepository roleRepository;
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

   public List<User> getAllUser(){

       return (List<User>) userRepository.findAll();
   }
    public User registerNewUser(User user) {
        Role role = roleRepository.findById("User").get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRole(roles);

        user.setUserPassword( getEncodedPassword(user.getUserPassword()));
        return userRepository.save(user);
    }

public  Staff registernewStaff(Staff staff){
       Role role = roleRepository.findById("Staff").get();
       Set<Role> roles = new HashSet<>();
       roles.add(role);
       staff.setRole(roles);
       staff.setUserPassword(getEncodedPassword(staff.getUserPassword()));
       return staffRepository.save(staff);
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

        Role staffRole = new Role();
        staffRole.setRoleName("Staff");
        staffRole.setRoleDescription("Role for staff");
        roleRepository.save(staffRole);



        User adminUser = new User();
        adminUser.setId(1);
        adminUser.setUserFirstName("Admin");
        adminUser.setUserLastName("admin");
//        adminUser.setUserName("admin");
        adminUser.setUserMiddleName("admin");
        adminUser.setUserName("admin");
        adminUser.setUserPassword(getEncodedPassword("admin123"));

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);

    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);

    }

}
