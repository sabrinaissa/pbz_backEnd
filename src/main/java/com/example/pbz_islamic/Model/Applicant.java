package com.example.pbz_islamic.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Applicant  extends User{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int applicantId;
    private String applicantName;
    private String nameOfEmployee;
    private String email;
    private String dbo;
    private int identityCard;
    private String address;
    private  String gender;

    @OneToMany
    private Set<Account> accounts;

//    @ManyToMany(mappedBy = "applicants")
//    private Set<Account> accounts;

}
