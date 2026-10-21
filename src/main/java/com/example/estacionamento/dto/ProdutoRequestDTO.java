package com.example.estacionamento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Service;

public class ProdutoRequestDTO {

    @NotBlank(message = "O nome do Produto é obrigatório e não pode conter só espaço")
    @Size(min = 3, max = 100, message = "O nome deve conter entre 3 e 100 caracteres")
    private String nome;

    @NotNull(message = "O preço do produto é obrigatório. ")
    @Positive(message = "O preço deve ser estritamente maior que zero.")
    private double preco;

    public ProdutoRequestDTO(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    public ProdutoRequestDTO() {
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
