package com.example.pbzBank.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String applicantFullName;
    private  String gender;
    private  String houseNo;
    private String street;
    private String ward;
    private  String SLP;
    private String city;
    private int  homeContact;
    private int officeContact;
    private  int mobilePhone;
    private  String email;
    private  int identityCard;
    private  int zssfNo;
    private  String nationality;
    private String dateOfBirth;
    private  String placeOfBirth;
    private  String  postalAddress;

    //Taarifa za mtu wa karibu

    private String  fullName;
    private  String address;
    private  int contact;
    private String nameOfEmployer;
    private  String dateOfEmployment;
    private  long employeesOfficeFileNo;
    private String periodOfServices;
    private  String parmanent;
    private  String nonparmanent;
    private  String startDate;
    private String endDate;
    //Taarifa za malipo

    private  long basicSalary;
    private long statutoryDeduction;
    private long anyOtherDeduction;
    private  long excludingAllowance;

    //Taarifa za ajira za nyuma
    private  String nameOfOrganization;
    private String dateOfEmployee;
    private  String applicationStatus;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
    private List<Loan> loans;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
