package br.fiap.assistencia.service;

import br.fiap.assistencia.domain.Cliente;
import br.fiap.assistencia.mapper.ClienteMapper;
import br.fiap.assistencia.repository.ClienteRepository;
import br.fiap.assistencia.web.dto.ClienteRequest;
import br.fiap.assistencia.web.dto.ClienteResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClienteService {

    private final ClienteRepository repo;
    private final ClienteMapper mapper;


    //metodo construtor pra inicializar as variaveis
    public ClienteService(ClienteRepository repo, ClienteMapper mapper) {

        this.repo = repo;
        this.mapper = mapper;
    }


    @Transactional //Uusa quando vc altera dados na tabela (insere, deleta e atualiza)
    public ClienteResponse salvar(ClienteRequest dto){

        Cliente cliente = mapper.paraEntidade(dto);

        Cliente aux = repo.save(cliente);

        return mapper.paraResposta(aux);
    }


    public ClienteResponse pesquisar(Long id){

        Cliente cliente = repo.findById(id).orElseThrow();

        return mapper.paraResposta(cliente);
    }


    public List<ClienteResponse> listar(){

        return repo.findAll()
                .stream()
                .map(cliente -> mapper.paraResposta(cliente))
                .toList();
    }


    //o deletar nao devolve nada, entao ele eh void
    public void deletar(Long id){

        repo.deleteById(id);
    }


    @Transactional //
    //o dto nao vai pro dto, so vai pro banco a entidade
    public ClienteResponse atualizar(Long id, ClienteRequest dto){

        Cliente cliente = repo.findById(id).orElseThrow();

        cliente.setEmail(dto.email());
        cliente.setNome(dto.nome());
        cliente.setTelefone(dto.telefone());
        cliente.setSenha(dto.senha()); //prx aula vmos fzr o hash da senha

        return mapper.paraResposta(cliente);
    }


    public ClienteResponse pesquisarPorEmail(String email){

        Cliente cliente = repo.findClienteByEmail(email).orElseThrow();

        return mapper.paraResposta(cliente);
    }

}
