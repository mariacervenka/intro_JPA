package br.fiap.assistencia.controller;

import br.fiap.assistencia.service.ClienteService;
import br.fiap.assistencia.web.dto.ClienteRequest;
import br.fiap.assistencia.web.dto.ClienteResponse;
import org.springframework.web.bind.annotation.*;

@RestController
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



}
