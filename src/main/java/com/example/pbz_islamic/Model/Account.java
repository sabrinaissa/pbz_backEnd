package com.example.pbz_islamic.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountNumber;
    private String accountName;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "applicantId")
    private Applicant applicant;

//    @ManyToMany
//    @JoinTable (
//            name = "accApplicant",
//            joinColumns = @JoinColumn(name = "accountNumber"),
//            inverseJoinColumns = @JoinColumn(name = "applicantId")
//    )
//    private Set<Applicant> applicants;
}
