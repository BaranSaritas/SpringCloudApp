package com.SpringCloud.account_service.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of="id")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "accounts")
public class Account   {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    @Column(value = "uname")
    private String username;
    @Column(value = "name")
    private String name;
    @Column(value = "surname")
    private String surname;
    @Column(value = "birth_date")
    private Date dateofBirthDate;
    @Column(value = "passwd")
    private String password;
    @Column(value = "email")
    private String email;
    @Column(value = "is_active")
    private boolean active;

}
