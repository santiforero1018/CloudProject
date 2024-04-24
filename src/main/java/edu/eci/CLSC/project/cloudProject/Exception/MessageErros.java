package edu.eci.CLSC.project.cloudProject.Exception;

public enum MessageErros {
    NOT_FOUND("CUENTA NO ENCONTRADA, POR FAVOR REVISE"),
    NOT_ENOUGHT_MONEY("FONDOS INSUFICIENTES"),
    NOT_MATCH_BANK("BANCO NO ENCONTRADO, POR FAVOR VERIFIQUE"),
    NOT_FOUND_USER("USUARIO O CONTRASEÑA INCORRECTOS"),
    NOT_FOUND_PROVIDER("PROVEEDOR NO ENCONTRADO"),
    INVALID_CREDENTIALS("CREDENCIALES INCORRECTAS, POR FAVOR REVISE");

    private final String message;

    MessageErros(String message){
        this.message = message;
    }

    public String getMessageError(){
        return this.message;
    }
}
