package com.SpringCloud.account_service.service;

import org.example.client.dto.AccountRequest;
import com.SpringCloud.account_service.mapper.AccountMapper;
import com.SpringCloud.account_service.model.Account;
import com.SpringCloud.account_service.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountRepository repository;
    private final AccountMapper mapper;


    @Override
    public AccountRequest getAccount(Long accountId) {
        Account account= repository.findById(accountId).orElseThrow(IllegalArgumentException::new);

        return mapper.AccountToAccountRequest(account);
    }

    @Override
    public AccountRequest createAccount(AccountRequest _account) {
        Account account = mapper.AccountRequestToAccount(_account);
        account = repository.save(account);
        _account.setId(account.getId());
        return _account;
    }

    @Override
    public AccountRequest update(AccountRequest _account,Long accountId) {
        Account account = repository.findById(accountId).orElseThrow(IllegalArgumentException::new);
        mapper.updateAccountFromAccountRequest(_account,account);
        repository.save(account);
        _account.setId(account.getId());
        return _account;
    }

    @Override
    public void delete(Long accountId) {
        Account account = repository.findById(accountId).orElseThrow(IllegalArgumentException::new);
        repository.delete(account);
    }

    @Override
    public List<AccountRequest> getAllAccounts() {
        List<Account> accounts= repository.findAll();
        return mapper.accountsToAccountRequests(accounts);
    }

}
