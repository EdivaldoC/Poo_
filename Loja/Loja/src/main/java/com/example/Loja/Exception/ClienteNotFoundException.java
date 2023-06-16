package com.example.Loja.Exception;

public class ClienteNotFoundException  extends RuntimeException{
    public  ClienteNotFoundException(Long id){
        super("Não foi possível encontrar o cliente  com o id " + id);
    }
}
