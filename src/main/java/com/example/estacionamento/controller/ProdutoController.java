package com.example.estacionamento.controller;

import com.example.estacionamento.model.Produto;
import com.example.estacionamento.sevice.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProduto(@RequestParam(required = false) String nome) {
        return ResponseEntity.ok(produtoService.buscarNome(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<?> cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
        try {
            Produto novoProduto = produtoService.cadastrarProduto(produtoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

      /*  @PutMapping("/{id}")
        public ResponseEntity<Produto> atualizarProduto (@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO){

        }*/


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean remover = produtoService.excluirProduto(id);
        if (remover) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }
}
