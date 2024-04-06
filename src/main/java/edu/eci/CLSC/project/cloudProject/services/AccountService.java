package edu.eci.CLSC.project.cloudProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.CLSC.project.cloudProject.Exception.AccountException;
import edu.eci.CLSC.project.cloudProject.Exception.MessageErros;
import edu.eci.CLSC.project.cloudProject.models.Account;

import edu.eci.CLSC.project.cloudProject.repositories.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccount(String accountNumber) throws AccountException {
        return this.accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountException(MessageErros.NOT_FOUND.getMessageError()));
    }

    public Account addAccount(Account newAccount) {
        return this.accountRepository.save(newAccount);
    }

    public void transaction(String accountNumberOr, String accountNumberDe, int amount) throws AccountException {
        Account origin = getAccount(accountNumberOr), destiny = getAccount(accountNumberDe);
        if(origin.getBalance() < amount){
            throw new AccountException(MessageErros.NOT_ENOUGHT_MONEY.getMessageError());
        }  

        destiny.setBalance(destiny.getBalance() + amount);
        origin.setBalance(origin.getBalance() - amount);

        this.accountRepository.save(destiny);
        this.accountRepository.save(origin);
    }

    public void deleteAccount(String  accountNumber) {
        this.accountRepository.deleteByAccountNumber(accountNumber);
    }
}
