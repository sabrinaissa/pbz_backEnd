package com.example.pbz_islamic.Controller;
import com.example.pbz_islamic.Exeption.ResourceNotFoundException;
import com.example.pbz_islamic.Model.Applicant;
import com.example.pbz_islamic.Repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/forAll/")
@RestController
public class ApplicantController {
    @Autowired
    private ApplicantRepository repository;

    @PostMapping("/Applicant")
    public Applicant newApplicant(@RequestBody Applicant applicant) {
        return repository.save(applicant);
    }

    @GetMapping("/Applicant/{applicantId}")
    public ResponseEntity<Applicant> getApplicantById(@PathVariable Integer applicantId) {
        Applicant applicant = repository.findById(applicantId).orElseThrow(() -> new ResourceNotFoundException("Applicant not found with id:" + applicantId));
        return ResponseEntity.ok(applicant);
    }

    @GetMapping("/Applicant")
    public List<Applicant> getAllApplicant() {
        return repository.findAll();
    }

    @PutMapping("/Applicant/{applicantId}")
    public ResponseEntity<Applicant> updateApplicant(@PathVariable Integer applicantId, @RequestBody Applicant applicantDetails) {
        Applicant applicant = repository.findById(applicantId).orElseThrow(() -> new ResourceNotFoundException("Applicant not found with id:" + applicantId));
        applicant.setApplicantName(applicantDetails.getApplicantName());
        applicant.setAddress(applicantDetails.getAddress());
        applicant.setNameOfEmployee(applicantDetails.getNameOfEmployee());
        applicant.setIdentityCard(applicantDetails.getIdentityCard());
        applicant.setDbo(applicantDetails.getDbo());
        applicant.setGender(applicantDetails.getGender());
        applicant.setEmail(applicantDetails.getEmail());
        Applicant updateApplicant = repository.save(applicant);
        return ResponseEntity.ok(updateApplicant);
    }

    @DeleteMapping("Applicant/{applicantId}")
    public ResponseEntity<Map<String, Boolean>> deleteApplicant(@PathVariable Integer applicantId) {
        Applicant applicant = repository.findById(applicantId).orElseThrow(() -> new ResourceNotFoundException("Applicant not found with id:" + applicantId));

        repository.delete(applicant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Applicant deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }



}
