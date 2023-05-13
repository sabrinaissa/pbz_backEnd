package com.example.pbz_islamic.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shopId;
    private String shopName;
    private double address;
}

