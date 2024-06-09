package com.SpringCloud.account_service.service;

import com.SpringCloud.account_service.model.Account;
import com.SpringCloud.account_service.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountRepository repository;
    @Override
    public Account getAccount(String accountId) {
        return repository.findById(accountId).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Account createAccount(Account account) {
        return null;
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public Object delete(String accountId) {
        return null;
    }

}
