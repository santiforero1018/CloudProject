package edu.eci.CLSC.project.cloudProject.models;

import lombok.Data;

@Data
public class Response {

    private String email;
    private boolean isAutenticate;

    public Response(){

    }

    public Response(String email, boolean isAutenticate){
        this.email = email;
        this.isAutenticate = isAutenticate;
    }

}
