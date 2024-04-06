package edu.eci.CLSC.project.cloudProject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "accounts")
@Data
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String  nir;
    private String accountNumber;
    private int  balance;
    private Long bankId;

    public Account(){}

    public Account(Long id, String nir, String accountNumber, int balance, Long bankId) {
        this.id = id;
        this.nir = nir;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bankId = bankId;
    }



}
