package com.example.estacionamento.sevice;

import com.example.estacionamento.controller.ProdutoDTO;
import com.example.estacionamento.model.Produto;
import com.example.estacionamento.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository Produtorepository;
    public ProdutoService(ProdutoRepository produtorepository) {
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
        return Produtorepository.findById(id);
    }
    public Produto cadastrarProduto(ProdutoDTO produtoDTO){

        if (produtoDTO.getPreco() <=0){
            throw new IllegalArgumentException("O preço do produto não pode ser menor ou igual a zero.");
        }

        if(produtoDTO.getNome()!= null || produtoDTO.getNome().trim().length() > 3){
            throw new IllegalArgumentException("O nome do produto deve ter no mínimo 3 caracteres.");

        }

        Produto novoProduto = new Produto(null, produtoDTO.getNome().trim(), produtoDTO.getPreco());
        return Produtorepository.save(novoProduto);
    }

    public boolean excluirProduto(Long id){
        return Produtorepository.deleteById(id);
    }

    }

