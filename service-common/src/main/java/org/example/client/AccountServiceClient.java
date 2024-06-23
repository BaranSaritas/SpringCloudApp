package org.example.client;


import org.example.client.dto.AccountRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("account-service")
public interface AccountServiceClient {
    @RequestMapping("/account/{accountId}")
    ResponseEntity<AccountRequest> getAccount(@RequestParam Long accountId);
}
