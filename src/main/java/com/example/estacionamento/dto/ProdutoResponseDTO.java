package com.example.estacionamento.dto;

import com.example.estacionamento.model.Produto;

public class ProdutoResponseDTO {
    private Long id;
    private String nome;
    private double preco;

    public ProdutoResponseDTO(Long id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public ProdutoResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
    public ProdutoResponseDTO fromEntity(Produto produto){
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getPreco());
    }
}
