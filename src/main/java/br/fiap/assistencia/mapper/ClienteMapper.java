package br.fiap.assistencia.mapper;

import br.fiap.assistencia.domain.Cliente;
import br.fiap.assistencia.web.dto.ClienteRequest;
import br.fiap.assistencia.web.dto.ClienteResponse;
import org.springframework.stereotype.Component;


@Component

public class ClienteMapper {

    //dto nao vai pro banco de dados
    public Cliente paraEntidade(ClienteRequest dto){

        Cliente cliente = new Cliente();

        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());
        cliente.setSenha(dto.senha());

        return cliente;
    }


    //entidade vai po banco de dados
    public ClienteResponse paraResposta(Cliente cliente){

        return new ClienteResponse(cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone());
    }

}
