package com.SpringCloud.account_service.service;

import com.SpringCloud.account_service.model.Account;

public interface AccountService {
    Account getAccount(String accountId);

    Account createAccount(Account account);

    Account update(Account account);

    Object delete(String accountId);

}
