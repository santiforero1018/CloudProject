package edu.eci.CLSC.project.cloudProject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "accounts")
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  nir;
    private String accountNumber;
    private int  balance;
    private Long providerId;

    public Account(){}

    public Account(Long id, String nir, String accountNumber, int balance, Long providerId) {
        this.id = id;
        this.nir = nir;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.providerId = providerId;
    }



}
