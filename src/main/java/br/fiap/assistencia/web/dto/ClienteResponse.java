package br.fiap.assistencia.web.dto;

public record ClienteResponse(
        Long id,
        String nome,
        String email,
        String telefone) {
}
