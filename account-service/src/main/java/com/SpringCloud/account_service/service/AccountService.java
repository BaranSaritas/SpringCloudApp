package com.SpringCloud.account_service.service;

import com.SpringCloud.account_service.model.Account;

import java.util.List;

public interface AccountService {
    Account getAccount(String accountId);

    Account createAccount(Account account);

    Account update(Account account);

    Object delete(String accountId);

     List<Account> getAllAccounts();
}
