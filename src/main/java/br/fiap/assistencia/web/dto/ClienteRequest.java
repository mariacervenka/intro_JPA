package br.fiap.assistencia.web.dto;

public record ClienteRequest(
        String nome,
        String email,
        String telefone,
        String senha) {
}
