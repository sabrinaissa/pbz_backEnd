package com.example.pbzBank.Controller;

import com.example.pbzBank.Model.Application;
import com.example.pbzBank.Model.Customer;
import com.example.pbzBank.Repository.ApplicationRepository;
import com.example.pbzBank.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin(originPatterns = "*")
public class ApplicationController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ApplicationRepository repository;
    @PostMapping("/application")
    public Application newApplication(@RequestBody Application application){
        application.setApplicationStatus("Pending");
        return repository.save(application);
    }
    @GetMapping("/application")
    public List<Application> getAllApplications(){
        return repository.findAll();
    }
    @GetMapping("/application/{id}")
    public ResponseEntity<Application> getById(@PathVariable Integer id){
        Application application = repository.findById(id)
                .orElseThrow(() ->new RuntimeException("id does not exist"+id));
        return ResponseEntity.ok(application);
    }

    @PutMapping("/application/{id}")
    public ResponseEntity<Application> updateApplication(@PathVariable Integer id, @RequestBody Application applicationDetails){
        Application application = repository.findById(id).get();
        application.setApplicantFullName(applicationDetails.getApplicantFullName());
        application.setGender(applicationDetails.getGender());
        application.setHouseNo(applicationDetails.getHouseNo());
        application.setStreet(applicationDetails.getStreet());
        application.setWard(applicationDetails.getWard());
        application.setSLP(applicationDetails.getSLP());
        application.setCity(applicationDetails.getCity());
        application.setHomeContact(applicationDetails.getHomeContact());
        application.setOfficeContact(applicationDetails.getOfficeContact());
        application.setMobilePhone(applicationDetails.getMobilePhone());
        application.setEmail(applicationDetails.getEmail());
        application.setIdentityCard(application.getIdentityCard());
        application.setZssfNo(applicationDetails.getZssfNo());
        application.setNationality(applicationDetails.getNationality());
        application.setDateOfBirth(applicationDetails.getDateOfBirth());
        application.setPlaceOfBirth(applicationDetails.getPlaceOfBirth());
        application.setPostalAddress(applicationDetails.getPostalAddress());
        application.setFullName(applicationDetails.getFullName());
        application.setAddress(applicationDetails.getAddress());
        application.setContact(applicationDetails.getContact());
        application.setNameOfEmployer(applicationDetails.getNameOfEmployer());
        application.setEmployeesOfficeFileNo(applicationDetails.getEmployeesOfficeFileNo());
        application.setPeriodOfServices(applicationDetails.getPeriodOfServices());
        application.setParmanent(applicationDetails.getParmanent());
        application.setNonparmanent(applicationDetails.getNonparmanent());
        application.setStartDate(applicationDetails.getStartDate());
        application.setEndDate(applicationDetails.getEndDate());
        application.setBasicSalary(applicationDetails.getBasicSalary());
        application.setStatutoryDeduction(applicationDetails.getStatutoryDeduction());
        application.setAnyOtherDeduction(applicationDetails.getAnyOtherDeduction());
        application.setExcludingAllowance(applicationDetails.getExcludingAllowance());
        application.setNameOfOrganization(applicationDetails.getNameOfOrganization());
        application.setDateOfEmployee(applicationDetails.getDateOfEmployee());
        if (!application.getApplicationStatus().equals("Approved") && !application.getApplicationStatus().
                equals("Rejected")) {
            application.setApplicationStatus("Pending");
        }
        Application updateApplication = repository.save(application);
        return ResponseEntity.ok(updateApplication);
    }
    @PutMapping("/application/accepted/{id}")
    public ResponseEntity<Application> acceptApplication(@PathVariable Integer id){
        Application application = repository.findById(id).get();
        application.setApplicationStatus("Approved");
        Application updateApplication = repository.save(application);
        return ResponseEntity.ok(updateApplication);
    }
      @PutMapping("/application/rejected/{id}")
    public ResponseEntity<Application> rejectApplication(@PathVariable Integer id){
        Application application = repository.findById(id).get();
        application.setApplicationStatus("Rejected");
        Application updateApplication = repository.save(application);
        return ResponseEntity.ok(updateApplication);
    }

    @DeleteMapping("/application/{id}")
    public  void  deleteApplication(@PathVariable Integer id){

        repository.deleteById(id);
    }

    @GetMapping("/application/accepted/total")
    public ResponseEntity<Integer> getTotalAcceptedApplications() {
        int totalAccepted = repository.countByApplicationStatus("Approved");
        return ResponseEntity.ok(totalAccepted);
    }

    @GetMapping("/application/pending/total")
    public ResponseEntity<Integer> getTotalPendingApplications() {
        int totalPending = repository.countByApplicationStatus("Pending");
        return ResponseEntity.ok(totalPending);
    }

    @GetMapping("/application/rejected/total")
    public ResponseEntity<Integer> getTotalRejectedApplications() {
        int totalRejected = repository.countByApplicationStatus("Rejected");
        return ResponseEntity.ok(totalRejected);
    }

    @GetMapping("/application/customer/{customerId}")
    public ResponseEntity<List<Application>> getApplicationsByCustomerId(@PathVariable Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            List<Application> applications = repository.findByCustomer(customer.get());
            return ResponseEntity.ok(applications);
        } else {
            // Customer not found
            return ResponseEntity.notFound().build();
        }
    }


}
