package com.example.pbzBank.Model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Customer extends User{
    private int accountNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Application> applications;
}
