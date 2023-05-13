package com.example.pbz_islamic.Controller;

import com.example.pbz_islamic.Exeption.ResourceNotFoundException;
import com.example.pbz_islamic.Model.Branch;
import com.example.pbz_islamic.Repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/forAll/")
@RestController
public class BranchController {
    @Autowired
    private BranchRepository repository;

    @PutMapping("/Branch/{branchId}")
    public ResponseEntity<Branch> updateBreach(@PathVariable Integer branchId, @RequestBody Branch breachDetails) {
        Branch branch = repository.findById(branchId).orElseThrow(() -> new ResourceNotFoundException("breach not found" + branchId));
        branch.setBranchName(breachDetails.getBranchName());
        branch.setAddress(breachDetails.getAddress());

        Branch updateBreach = repository.save(branch);
        return ResponseEntity.ok(updateBreach);
    }

    @DeleteMapping("/Branch/{branchId}")
    public ResponseEntity<Map<String, Boolean>> deleteBranch(@PathVariable Integer branchId) {
        Branch branch = repository.findById(branchId).orElseThrow(() -> new ResourceNotFoundException("branch not found"));
        repository.delete(branch);
        Map<String, Boolean> response = new HashMap<>();
        response.put("branch delete", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }

    @PostMapping("/Branch")
    public Branch newBranch(@RequestBody Branch branch) {
        return repository.save(branch);
    }
    @PostMapping("/Branches")
    public List<Branch> saveAllBranch(@RequestBody List<Branch> branch){
        return repository.saveAll(branch);
    }

    @GetMapping("/Branch/{branchId}")
    public ResponseEntity<Branch> getBranchById(@PathVariable Integer branchId) {
        Branch branch = repository.findById(branchId).orElseThrow(() -> new RuntimeException("branch not found" + branchId));
        return ResponseEntity.ok(branch);

    }

    @GetMapping("/Branch")
    public List<Branch> getAllBranch() {
        return repository.findAll();
    }

}
