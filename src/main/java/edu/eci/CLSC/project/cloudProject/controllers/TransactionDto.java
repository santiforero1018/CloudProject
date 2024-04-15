package edu.eci.CLSC.project.cloudProject.controllers;

import lombok.Data;

@Data
public class TransactionDto {
    private String nit;
    private String bank;
    private int amount;
    private String accountNumber;

    public TransactionDto(){}

    public TransactionDto(String nit, String bank, int amount, String accountNumber) {
        this.nit = nit;
        this.bank = bank;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }
}
