package edu.eci.CLSC.project.cloudProject.services;

import edu.eci.CLSC.project.cloudProject.Exception.AccountException;
import edu.eci.CLSC.project.cloudProject.models.Account;

public interface AccountService {

    public Account getAccount(String accountNumber) throws AccountException;

    public Account addAccount(Account newAccount);

    public void transaction(Account accountOr, Account accountDe, int amount) throws AccountException;

    public void deleteAccount(String  accountNumber);
}
