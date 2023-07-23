package com.example.pbzBank.Controller;

import com.example.pbzBank.Model.Staff;
import com.example.pbzBank.Repository.StaffRepository;
import com.example.pbzBank.Repository.UserRepository;
import com.example.pbzBank.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/v1")
public class StaffController {
    @Autowired
    private UserService service;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StaffRepository repository;

  @PostMapping("/staff")
    public  Staff registerNewStaff(@RequestBody Staff staff){
        return service.registernewStaff(staff);
    }

    @GetMapping("/staff")
    public Iterable<Staff> getAllStaff(){
        return repository.findAll();
    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable long id){
        Staff staff = repository.findById(id).get();
        return ResponseEntity.ok(staff);
    }

    @PutMapping("/staff/{id}")
    public String updateStaff(@PathVariable Long id, @RequestBody Staff staffDetails){
        Staff staff = repository.findById(id).get();
        staff.setUserName(staffDetails.getUserName());
        staff.setUserPassword(staffDetails.getUserPassword());
        staff.setUserFirstName(staffDetails.getUserFirstName());
        staff.setUserMiddleName(staffDetails.getUserMiddleName());
        staff.setUserLastName(staffDetails.getUserLastName());
        staff.setTitle(staffDetails.getTitle());
        Staff updateStaff = repository.save(staff);
        return "Updated successful!"+ updateStaff;

    }

    @DeleteMapping("/staff/{id}")
    public  String deleteStaff(@PathVariable Long id){
        repository.deleteById(id);
        return "staff deleted successful!"+id;
    }
}
