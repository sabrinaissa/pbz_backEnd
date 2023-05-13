package com.example.pbz_islamic.Controller;

import com.example.pbz_islamic.Model.Facility;
import com.example.pbz_islamic.Repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/forAll/")
@RestController
public class FacilityController {
    @Autowired
    private FacilityRepository repository;
     @PutMapping("/Facility/{facilityId}")
    public ResponseEntity<Facility> updateFacility(@PathVariable Integer facilityId, @RequestBody Facility facilityDetails){
        Facility facility = repository.findById(facilityId)
                .orElseThrow(() -> new RuntimeException("facility not found"+facilityId));
        facility.setFacilityName(facilityDetails.getFacilityName());
        facility.setPrice(facilityDetails.getPrice());

        Facility updateFacility = repository.save(facility);
        return ResponseEntity.ok(updateFacility);
    }
    @DeleteMapping("/Facility/{facilityId}")
    public ResponseEntity<Map<String, Boolean>> deleteFacility(@PathVariable Integer facilityId){
         Facility facility = repository.findById(facilityId)
                 .orElseThrow(()->new RuntimeException("facility not found"+facilityId));
         repository.delete(facility);
         Map<String, Boolean> response = new HashMap<>();
         response.put("facility deleted", Boolean.TRUE);
         return ResponseEntity.ok(response);
    }
    @GetMapping("Facility/{facilityId}")
    public ResponseEntity<Facility> getFacilityById(@PathVariable Integer facilityId){
         Facility facility = repository.findById(facilityId)
                 .orElseThrow(()-> new RuntimeException("facility not found"+facilityId));
         return ResponseEntity.ok(facility);
    }
    @GetMapping("Facility")
    public List<Facility> getAllFacility(){
         return repository.findAll();
    }
    @PostMapping("/Facility")
    public Facility newFacility(@RequestBody Facility facility){
         return repository.save(facility);
    }
}
