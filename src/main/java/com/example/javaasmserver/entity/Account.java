package com.example.javaasmserver.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;
    private String password;
    private int role; // 1.Admin, 2.User
    private int status; // 1.Active, 2,Deactive

    @OneToMany(mappedBy="account", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private Set<Credential> credentials = new HashSet<>();

    public void setCredentials(Set<Credential> credentials) {
        this.credentials = credentials;

        for(Credential c : credentials) {
            c.setAccount(this);
        }
    }

    public Account(String userName, String password, int role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getRole() {
        return role == 2 ? "ADMIN" : "USER";
    }
}
