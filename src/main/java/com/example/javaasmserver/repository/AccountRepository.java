package com.example.javaasmserver.repository;

import com.example.javaasmserver.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUserName(String username);
//
//    Optional<Account> findByToken(String token);
}
