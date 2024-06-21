package com.SpringCloud.account_service.dto.request;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {
    private String id;
    private String username;
    private String name;
    private String surname;
    private Date dateofBirthDate;
    private String email;

}
