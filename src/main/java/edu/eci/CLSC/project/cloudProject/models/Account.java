package edu.eci.CLSC.project.cloudProject.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "bank_id")
    @JsonBackReference
    private Bank bank;

    public Account(){}

    public Account(Long id, String nir, String accountNumber, int balance, Bank bank) {
        this.id = id;
        this.nir = nir;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }



}
