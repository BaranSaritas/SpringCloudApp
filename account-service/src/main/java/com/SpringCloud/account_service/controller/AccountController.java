package com.SpringCloud.account_service.controller;


import com.SpringCloud.account_service.dto.request.AccountRequest;
import com.SpringCloud.account_service.model.Account;
import com.SpringCloud.account_service.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountRequest> getAccount(@RequestParam Long accountId){
        return ResponseEntity.ok(accountService.getAccount(accountId));
    }
    @GetMapping
    public ResponseEntity<List<AccountRequest>> getAllAccounts(){
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
    @PostMapping
    public ResponseEntity<AccountRequest> createAccount(@RequestBody AccountRequest account){
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @PutMapping("/{accountId}")
        public ResponseEntity<AccountRequest> updateAccount(@RequestBody AccountRequest account,@PathVariable Long accountId){
        return ResponseEntity.ok(accountService.update(account,accountId));
    }

    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable Long accountId){
        accountService.delete(accountId);
    }

}
