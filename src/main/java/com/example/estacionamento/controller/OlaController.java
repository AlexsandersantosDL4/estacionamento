package com.example.estacionamento.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OlaController {

    @GetMapping("/ola")
    public String ola(){
        return "Bem Vindo";
    }
    @GetMapping("/status")
    public StatusSistemaDTO statusSistemaDTO(){
        return new StatusSistemaDTO(
                "Sistema Senai de Ensino de Qualidade",
                "1.0",
                "Rodando a todo vapor",
                5

        );
    }
    @GetMapping("/autor")
    public String exibirAutor(){
        return "Alex Aluno do Curso de Programador Back-End SENAI";
    }
    @GetMapping("hora-servidor")
    public String exibirHoraDoServidor(){
        return "Horario do servidor " + java.time.LocalDateTime.now();
    }
    @GetMapping("/promocao")
    public ProdutoPreviewDTO obterPromocao() {
        double original = 22.00;
        double comDesconto = original * 0.90;
        return new ProdutoPreviewDTO("batata frita", original, comDesconto);
    }
    @GetMapping("/cursos")
    public java.util.List<String> listarCursos() {
        return java.util.List.of(
                "Lógica de Programação Java",
                "Orientação a Objetos",
                "Spring Boot REST com SQLite"
        );
    }
}
