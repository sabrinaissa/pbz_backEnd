package com.example.pbzBank.Repository;

import com.example.pbzBank.Model.Application;
import com.example.pbzBank.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Integer> {
    int countByApplicationStatus(String accepted);
    List<Application> findByCustomerId(int customerId);

    List<Application> findByCustomer(Customer customer);
}
