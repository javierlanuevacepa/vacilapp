package com.example.vacilapp;

public class ApiError {

    private String mensaje;

    public ApiError(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje(){
        return this.mensaje;
    }

}
