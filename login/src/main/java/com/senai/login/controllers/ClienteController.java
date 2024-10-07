package com.senai.login.controllers;

import com.senai.login.dtos.ClienteDto;
import com.senai.login.dtos.RespostaDto;
import com.senai.login.models.ClienteModel;
import com.senai.login.services.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    public ResponseEntity<RespostaDto> cadastrarCliente(@RequestBody ClienteDto cliente) {

        boolean retorno = clienteService.cadastrarCliente(cliente);

        RespostaDto resposta = new RespostaDto();
        resposta.setMensagem(retorno ? "Cadastro realizado com sucesso" : "Erro ao realizar o cadastro");

        return ResponseEntity.status(HttpStatus.OK).body(resposta);

    }

    @PutMapping("/atualizarcliente/{email}")
    public ResponseEntity<RespostaDto> atualizarCliente(@RequestBody ClienteDto cliente, @PathVariable String email) {

        boolean retorno = clienteService.atualizarCliente(cliente, email);

        RespostaDto resposta = new RespostaDto();

        resposta.setMensagem(retorno ? "Atualização realizado com sucesso" : "Erro ao realizar atualização");

        return ResponseEntity.status(HttpStatus.OK).body(resposta);

    }

    @GetMapping("/cliente")
    public ResponseEntity<List<ClienteModel>> obterClientes() {

        List<ClienteModel> lista = clienteService.obterClientes();

        return ResponseEntity.status(HttpStatus.OK).body(lista);

    }

    @DeleteMapping("/cliente/{codigo}")
    public ResponseEntity<RespostaDto> deletarCliente(@PathVariable Long codigo) {

        boolean retorno = clienteService.excluirCliente(codigo);

        RespostaDto resposta = new RespostaDto();

        resposta.setMensagem(retorno ? "Delete realizado com sucesso" : "Erro ao realizar delete");

        return ResponseEntity.status(HttpStatus.OK).body(resposta);

    }

}
