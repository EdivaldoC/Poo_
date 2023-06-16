package com.example.Loja.Exception;

public class LojaNotFoundException extends RuntimeException {
    public  LojaNotFoundException(Long id){
        super("Não foi possível encontrar a loja  com o id " + id);
    }
}
