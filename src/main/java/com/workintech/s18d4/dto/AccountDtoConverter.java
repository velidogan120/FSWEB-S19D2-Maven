package com.workintech.s18d4.dto;

import com.workintech.s18d4.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDtoConverter {

    public AccountResponse convert(Account account) {
        return new AccountResponse(account.getId(), account.getAccountName(),
                account.getMoneyAmount());
    }

    public List<AccountResponse> convertAccountResponseList(List<Account> accounts) {
        List<AccountResponse> accountResponseList = new ArrayList<>();
        for (Account account : accounts) {
            accountResponseList.add(convert(account));
        }
        return accountResponseList;
    }
}
