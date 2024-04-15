package edu.eci.CLSC.project.cloudProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.eci.CLSC.project.cloudProject.models.Account;
import edu.eci.CLSC.project.cloudProject.models.Bank;
import edu.eci.CLSC.project.cloudProject.models.Provider;
import edu.eci.CLSC.project.cloudProject.repositories.AccountRepository;
import edu.eci.CLSC.project.cloudProject.repositories.BankRepository;
import edu.eci.CLSC.project.cloudProject.repositories.ProviderRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        
        Bank bank = new Bank();
        bank.setName("Banco de Prueba");
        if(!bankRepository.existsByName(bank.getName())){
            bankRepository.save(bank);
        }
        

        
        Account account = new Account();
        account.setNir("123456789");
        account.setAccountNumber("ABC123");
        account.setBalance(1000);
        account.setBank(bank);
        if(!accountRepository.existsByAccountNumber(account.getAccountNumber())){
            accountRepository.save(account);
        }
        

        
        Provider provider = new Provider();
        provider.setName("Proveedor de Prueba");
        provider.setNit("123456789-1");
        provider.setDirection("Calle 123");
        provider.setPhone("1234567890");
        provider.setAccount(account);
        if(!providerRepository.existsByNit(provider.getNit())){
            providerRepository.save(provider);
        }
        
    }
}