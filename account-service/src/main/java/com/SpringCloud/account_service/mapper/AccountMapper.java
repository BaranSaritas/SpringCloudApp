package com.SpringCloud.account_service.mapper;

import org.example.client.dto.AccountRequest;
import com.SpringCloud.account_service.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountRequest AccountToAccountRequest (Account request);
    Account AccountRequestToAccount(AccountRequest request);
    List<AccountRequest> accountsToAccountRequests(List<Account> accounts);
    @Mapping(target = "id", ignore = true)
    void updateAccountFromAccountRequest(AccountRequest request, @MappingTarget Account account);
}
