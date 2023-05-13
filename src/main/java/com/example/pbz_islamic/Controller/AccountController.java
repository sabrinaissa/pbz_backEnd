package com.example.pbz_islamic.Controller;
import com.example.pbz_islamic.Exeption.ResourceNotFoundException;
import com.example.pbz_islamic.Model.Account;
import com.example.pbz_islamic.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/forAll/")
@RestController
public class AccountController {
    @Autowired
    private AccountRepository repository;

    @PostMapping("/Account")
    public Account newAccount(@RequestBody Account account){
        return repository.save(account);
    }
    @GetMapping("/Account/{accountNumber}")
    public ResponseEntity<Account> getAccountById(@PathVariable Integer accountNumber){
        Account account = repository.findById(accountNumber)
                .orElseThrow(()->new ResourceNotFoundException("account not found"+accountNumber));
        return ResponseEntity.ok(account);
    }

    @PostMapping("/Accounts")
    public List<Account> getAllAccount(){
        return repository.findAll();
    }

    @DeleteMapping("Account/{accountNumber}")
    public ResponseEntity<Map<String,Boolean>> deleteAccount(@PathVariable Integer accountNumber){
        Account account = repository.findById(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("account not found:"+accountNumber));
        repository.delete(account);
        Map<String, Boolean> response = new HashMap<>();
        response.put("account deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }

    @PutMapping("/Account/{accountNumber}")
    public ResponseEntity<Account> updateAccount(@PathVariable Integer accountNumber,@RequestBody Account accountDetails){
        Account account = repository.findById(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("account not found"+accountNumber));
        account.setAccountName(accountDetails.getAccountName());
        account.setDate(accountDetails.getDate());
        Account updateAccount = repository.save(account);
        return ResponseEntity.ok(updateAccount);
    }



}
