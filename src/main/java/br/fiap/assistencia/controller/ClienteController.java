package br.fiap.assistencia.controller;

import br.fiap.assistencia.service.ClienteService;
import br.fiap.assistencia.web.dto.ClienteRequest;
import br.fiap.assistencia.web.dto.ClienteResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //API REST, VAI DADO VOLTA GRAFICO
@RequestMapping("/cliente")


public class ClienteController {

    //para nao conseguir mudar a variavel
    private final ClienteService service;


    //metodo contrutor pra inicializar a variavel
    public ClienteController(ClienteService service) {
        this.service = service;
    }


    //metodo salvar - save
    @PostMapping("/salvar")
    public ClienteResponse salvar(@RequestBody ClienteRequest dto){

        return service.salvar(dto);
    }


    //select com id
    //{} conteudo de uma variavel - varios dados do json
    @GetMapping("/pesquisar/{id}")
    public ClienteResponse pesquisar(@PathVariable Long id){ //ca,minho variavel

        return service.pesquisar(id);
    }


    @GetMapping("/listar")
    public List<ClienteResponse> listar(){

        return service.listar();
    }


    //parecido com o pesquisar mas a dif eh que nao volta nenhum valor
    //pode usar o @DeleteMapping se quisar
    @GetMapping("/deletar")
    public void deletar(@PathVariable Long id){

        service.deletar(id);
    }


    @PutMapping("/atualizar/{id}")
    public ClienteResponse atualizar(@PathVariable Long id, @RequestBody ClienteRequest dto){

        return service.atualizar(id, dto);
    }


    @GetMapping("/pesquisar-email/{email}")
    public ClienteResponse pesquisarPorEmail(@PathVariable String email){

        return service.pesquisarPorEmail(email);
    }

}
