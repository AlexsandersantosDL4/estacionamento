    package com.example.estacionamento.controller;

    import com.example.estacionamento.model.Produto;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Locale;

    @RestController
    @RequestMapping("/api/produtos")
    public class ProdutoController {

        }

        @GetMapping
        public ResponseEntity<List<Produto>> Listar(@RequestParam(required = false) String nome) {
            if (nome != null && !nome.isBlank()) {
                List<Produto> filtrados = catalogo.stream()
                        .filter(produto -> produto.getNome().toLowerCase().contains(nome.toLowerCase()))
                        .toList();
                return ResponseEntity.ok(filtrados);
            }
            return ResponseEntity.ok(catalogo);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
            return catalogo.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<Produto> criar(@RequestBody ProdutoDTO dto) {
            Produto novoProduto = new Produto(proximoID++, dto.getNome(), dto.getPreco());
            catalogo.add(novoProduto);
            return ResponseEntity.status(org.springframework.http.HttpStatus.CREATED).body(novoProduto);
        }

        @PutMapping("{id}")
        public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
            for (Produto p : catalogo) {
                if (p.getId().equals(id)) {
                    p.setNome(dto.getNome());
                    p.setPreco(dto.getPreco());
                    return ResponseEntity.ok(p);
                }
            }
            return ResponseEntity.notFound().build();
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> excluir(@PathVariable Long id){
            boolean remover = catalogo.removeIf(produto -> produto.getId().equals(id));

            if (remover){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.noContent().build();
        }
    }

