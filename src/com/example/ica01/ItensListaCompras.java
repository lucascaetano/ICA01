package com.example.ica01;

public class ItensListaCompras {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public String getNomeitem() {
        return nomeitem;
    }

    public void setNomeitem(String nomeitem) {
        this.nomeitem = nomeitem;
    }

    private int id;
    private String nomeLista;
    private String nomeitem;




   

    public ItensListaCompras(int id, String nomeLista, String nomeitem, String numItens, String comprado) {
        this.id = id;
        this.nomeLista = nomeLista;
        this.nomeitem = nomeitem;
        this.numItens = numItens;
        this.comprado = comprado;
    }
    
    private String numItens;
    private String comprado;

    public String getNumItens() {
        return numItens;
    }

    public void setNumItens(String numItens) {
        this.numItens = numItens;
    }

    public String getComprado() {
        return comprado;
    }

    public void setComprado(String comprado) {
        this.comprado = comprado;
    }
}
