package edu.eci.CLSC.project.cloudProject.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.CLSC.project.cloudProject.Exception.BankException;
import edu.eci.CLSC.project.cloudProject.Exception.MessageErros;
import edu.eci.CLSC.project.cloudProject.models.Bank;
import edu.eci.CLSC.project.cloudProject.repositories.BankRepository;
import edu.eci.CLSC.project.cloudProject.services.BankService;

@Service
public class BankServiceMap implements BankService {
    
    @Autowired
    private BankRepository bankRepository;

    @Override
    public Bank getBank(String name) throws BankException{
        return this.bankRepository.findByName(name).orElseThrow(() -> new BankException(MessageErros.NOT_MATCH_BANK.getMessageError()));
    }

    @Override
    public void addBank(Bank newBank){
        this.bankRepository.save(newBank);
    }

}
