package com.example.pbz_islamic.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int facilityId;
    private String facilityName;
    private double price;

}
