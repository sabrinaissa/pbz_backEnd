package com.example.pbzBank.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int facilityId;
    private String facilityName;
    private double price;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

}
