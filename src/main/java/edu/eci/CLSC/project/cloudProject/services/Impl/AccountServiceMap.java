package edu.eci.CLSC.project.cloudProject.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.CLSC.project.cloudProject.Exception.AccountException;
import edu.eci.CLSC.project.cloudProject.Exception.MessageErros;
import edu.eci.CLSC.project.cloudProject.models.Account;

import edu.eci.CLSC.project.cloudProject.repositories.AccountRepository;
import edu.eci.CLSC.project.cloudProject.services.AccountService;

@Service
public class AccountServiceMap implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getAccount(String accountNumber) throws AccountException {
        return this.accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountException(MessageErros.NOT_FOUND.getMessageError()));
    }

    @Override
    public Account addAccount(Account newAccount) {
        return this.accountRepository.save(newAccount);
    }

    @Override
    public void transaction(Account accountOr, Account accountDe, int amount) throws AccountException {
        if(accountOr.getBalance() < amount){
            throw new AccountException(MessageErros.NOT_ENOUGHT_MONEY.getMessageError());
        }  

        accountDe.setBalance(accountDe.getBalance() + amount);
        accountOr.setBalance(accountOr.getBalance() - amount);

        this.accountRepository.save(accountDe);
        this.accountRepository.save(accountOr);
    }

    @Override
    public void deleteAccount(String  accountNumber) {
        this.accountRepository.deleteByAccountNumber(accountNumber);
    }
}
