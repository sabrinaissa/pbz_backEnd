package com.example.pbz_islamic.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;

import static jakarta.persistence.GenerationType.*;

@Data
@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int branchId;
    private String branchName;
    private String address;


}
