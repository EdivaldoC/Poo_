package com.example.Loja.Exception;

public class VendedorNotFoundException extends RuntimeException {
    public VendedorNotFoundException(Long id){
        super("Não foi possível encontrar o vendedor com o id " + id);
    }
}
