package com.SpringCloud.account_service.controller;


import com.SpringCloud.account_service.model.Account;
import com.SpringCloud.account_service.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccount(@RequestParam String accountId){
        return ResponseEntity.ok(accountService.getAccount(accountId));
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        return ResponseEntity.ok(accountService.createAccount(account));
    }
@PutMapping
    public ResponseEntity<Account> updateAccount(@RequestBody Account account){
return ResponseEntity.ok(accountService.update(account));
    }
    @DeleteMapping
    public void deleteAccount(@RequestParam String accountId){
        accountService.delete(accountId);
    }

}
