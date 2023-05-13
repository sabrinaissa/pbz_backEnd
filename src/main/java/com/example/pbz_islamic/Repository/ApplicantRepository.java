package com.example.pbz_islamic.Repository;

import com.example.pbz_islamic.Model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
    ResponseEntity<Applicant> findByEmail(String email);
}
