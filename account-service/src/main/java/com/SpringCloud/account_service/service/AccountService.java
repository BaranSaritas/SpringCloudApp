package com.SpringCloud.account_service.service;

import com.SpringCloud.account_service.dto.request.AccountRequest;

import java.util.List;

public interface AccountService {
    AccountRequest getAccount(Long accountId);

    AccountRequest createAccount(AccountRequest account);

    AccountRequest update(AccountRequest account,Long accountId);

    void delete(Long accountId);

     List<AccountRequest> getAllAccounts();
}
