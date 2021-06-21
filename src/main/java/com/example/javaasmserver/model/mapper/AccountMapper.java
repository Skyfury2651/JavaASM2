package com.example.javaasmserver.model.mapper;

import com.example.javaasmserver.entity.Account;
import com.example.javaasmserver.model.dto.AccountDTO;

public class AccountMapper {
    public static AccountDTO accountDTO (Account account) {
        AccountDTO tmp = new AccountDTO();
        tmp.setUserName(account.getUserName());
        tmp.setPassword(account.getPassword());
        return tmp;
    }
}
