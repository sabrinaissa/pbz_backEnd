package com.example.pbzBank.Model;

import lombok.Data;

import javax.persistence.Entity;
@Data
@Entity
public class Staff extends User{
    private String Title;
}
