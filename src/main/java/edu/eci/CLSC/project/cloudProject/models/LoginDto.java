package edu.eci.CLSC.project.cloudProject.models;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;

    public LoginDto(){

    }

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
