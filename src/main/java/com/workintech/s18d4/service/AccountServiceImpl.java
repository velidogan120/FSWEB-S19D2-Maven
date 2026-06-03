package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account find(long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Account update(Account account) {
        return accountRepository.save(account);
    }

    public Account delete(long id) {
        Optional<Account> account = accountRepository.findById(id);

        if (account.isEmpty()) {
            return null;
        }

        accountRepository.delete(account.get());
        return account.get();
    }
}
