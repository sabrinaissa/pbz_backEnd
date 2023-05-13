package com.example.pbz_islamic.Repository;

import com.example.pbz_islamic.Model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<Facility,Integer> {
}
