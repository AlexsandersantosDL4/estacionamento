package com.example.estacionamento.controller;

public class ProdutoPreviewDTO {
    private String nome;
    private double precoOriginal;
    private double precoComDesconto;

    public ProdutoPreviewDTO(String nome, double precoOriginal, double precoComDesconto) {
        this.nome = nome;
        this.precoOriginal = precoOriginal;
        this.precoComDesconto = precoComDesconto;
    }

    public String getNome() { return nome; }
    public double getPrecoOriginal() { return precoOriginal; }
    public double getPrecoComDesconto() { return precoComDesconto; }
}





