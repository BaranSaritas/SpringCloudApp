package com.SpringCloud.account_service.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@ToString
@Table(value = "accounts")
public class Account extends BaseModel  implements Serializable  {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    @Column(value = "uname")
    private String username;
    @Column(value = "passwd")
    private String password;
    @Column(value = "email")
    private String email;
    @Column(value = "is_active")
    private boolean active;

}
