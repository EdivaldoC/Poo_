package com.example.Loja.Dto;

public class LojaDTO {
    private long id;
    private String nomeLoja;
    private String CnpjLoja;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getnomeLoja() {
        return nomeLoja;
    }

    public void setnomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public String getCnpjLoja() {
        return CnpjLoja;
    }

    public void setCnpjLoja(String CnpjLoja) {
        this.CnpjLoja = CnpjLoja;
    }
}
