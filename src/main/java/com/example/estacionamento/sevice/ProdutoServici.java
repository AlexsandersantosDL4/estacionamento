package com.example.estacionamento.sevice;

import com.example.estacionamento.model.Produto;
import com.example.estacionamento.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServici {

    private final ProdutoRepository Produtorepository;
    public ProdutoServici(ProdutoRepository produtorepository) {
        Produtorepository = produtorepository;
    }
    public List<Produto> listarTodos(){
        return new ArrayList<>(Produtorepository.findAll());
    }
    public List<Produto> buscarNome(String nome){
        List<Produto> listarNomes = Produtorepository.findAll();
        if(nome != null && nome.isBlank()){
            return  listarNomes.stream().filter(
                    produto -> produto.getNome().toLowerCase().contains(nome.toLowerCase()
                    )
            ).toList();
        }
        return listarNomes;
    }

    public Optional<Produto> buscarPorId(Long id){
        return Produtorepository.findBtId(id);
    }

    }

