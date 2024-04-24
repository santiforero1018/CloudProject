package edu.eci.CLSC.project.cloudProject.controllers;

import lombok.Data;

@Data
public class LoginDto {
    private String userName;
    private String password;

    public LoginDto(){

    }

    public LoginDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
