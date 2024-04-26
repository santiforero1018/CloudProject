package edu.eci.CLSC.project.cloudProject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.eci.CLSC.project.cloudProject.models.Account;
import edu.eci.CLSC.project.cloudProject.models.Bank;
import edu.eci.CLSC.project.cloudProject.models.Provider;
import edu.eci.CLSC.project.cloudProject.models.User;
import edu.eci.CLSC.project.cloudProject.repositories.AccountRepository;
import edu.eci.CLSC.project.cloudProject.repositories.BankRepository;
import edu.eci.CLSC.project.cloudProject.repositories.ProviderRepository;
import edu.eci.CLSC.project.cloudProject.repositories.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private UserRepository userRepository;

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
        account.setBalance(100000);
        account.setBank(bank);
        if(!accountRepository.existsByAccountNumber(account.getAccountNumber())){
            accountRepository.save(account);
        }

        Account account2 = new Account();
        account2.setNir("987654321");
        account2.setAccountNumber("ZXY987");
        account2.setBalance(80000000);
        account2.setBank(bank);
        if(!accountRepository.existsByAccountNumber(account2.getAccountNumber())){
            accountRepository.save(account2);
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

        User proofUser = new User();
        proofUser.setEmail("admin@gmail.com");
        proofUser.setPassword(hashPwd("admin1234"));
        if(!this.userRepository.existsByEmail(proofUser.getEmail())){
            this.userRepository.save(proofUser);
        }
        
    }

    public String hashPwd(String chain) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(chain.getBytes());
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("problems hashing");
        }

        return null;

    }
}