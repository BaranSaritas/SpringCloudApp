package com.SpringCloud.account_service.dto.request;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.util.Date;
import java.util.UUID;

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
