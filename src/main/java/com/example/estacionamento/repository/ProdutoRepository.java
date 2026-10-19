package com.example.estacionamento.repository;

import com.example.estacionamento.controller.ProdutoDTO;
import com.example.estacionamento.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository {
    private final List<Produto> dados = new ArrayList<>();
    private long proximoID = 1L;

    public ProdutoRepository() {
        dados.add(new Produto(proximoID++, "Batata Frita", 20.00));
        dados.add(new Produto(proximoID++, "Hamburguer", 22.00));
        dados.add(new Produto(proximoID++, "Refrigerante", 12.99));
    }

    public List<Produto> findAll() {
        return new ArrayList<>(dados);
        //buscar produtos
    }

    public Optional<Produto> findById(Long id) {
        return dados.stream().filter(
                produto -> produto.getId().equals(id)).findFirst();
    }

    public Produto save(Produto produto) {
        if (produto.getId() == null) {
            produto.setId(proximoID++);
            dados.add(produto);
            //salvar produto
        }else {
            deleteById(produto.getId());
            dados.add(produto);
        }
        return produto;
    }
    public boolean deleteById(Long id) {
        return dados.removeIf(produto -> produto.getId().equals(id));
        //deletar produto
    }
}

