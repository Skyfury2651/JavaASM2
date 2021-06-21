package com.example.javaasmserver.config;

import com.example.javaasmserver.entity.Account;
import com.example.javaasmserver.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyAccountDetailsService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // lay user
        Optional<Account> user = accountRepository.findByUserName(userName);
        if (user.isPresent()) {
        	Account u = user.get();

            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                    .username(u.getUserName())
                    .password(u.getPassword())
                    .roles(u.getRole())
                    .build();
            return userDetails;
        }


        return null;
    }
}
