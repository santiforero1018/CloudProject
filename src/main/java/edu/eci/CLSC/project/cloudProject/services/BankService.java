package edu.eci.CLSC.project.cloudProject.services;

import edu.eci.CLSC.project.cloudProject.Exception.BankException;
import edu.eci.CLSC.project.cloudProject.models.Bank;

public interface BankService {
    
    public Bank getBank(String name) throws BankException;

    public void addBank(Bank newBank);
}
