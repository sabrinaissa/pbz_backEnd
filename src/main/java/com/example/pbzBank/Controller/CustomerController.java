package com.example.pbzBank.Controller;

import com.example.pbzBank.Model.Customer;
import com.example.pbzBank.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository repository;
    @PostMapping("/newCustomer")
    public Customer newCustomer(@RequestBody Customer customer){

        return repository.save(customer);
    }

    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCustomer(){
        return repository.findAll();
    }
}
