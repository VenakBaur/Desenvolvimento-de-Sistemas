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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;
    
    @PostMapping()
    public  ResponseEntity<RespostaDto> cadastrarCliente(@RequestBody ClienteDto cliente){
        
        boolean retorno =  clienteService.cadastraCliente(cliente);
        
        RespostaDto resposta = new RespostaDto();
        resposta.setMensagem(retorno ? "Cadastro realizado com sucesso" : "Erro ao realizar cadastro");
        
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
        
    }
    
    //-- PUT http://localhost:8080/usuario/admin
    @PutMapping("{id}")
    public  ResponseEntity<RespostaDto> atualizarCliente(@RequestBody ClienteDto cliente, @PathVariable Long id){
        
        boolean retorno =  clienteService.atualizarCliente(id, cliente);
        
        RespostaDto resposta = new RespostaDto();
        resposta.setMensagem(retorno ? "Atualização realizado com sucesso" : "Erro ao realizar atualização");
        
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }
    
    //-- DELETE http://localhost:8080/usuario/4
    @DeleteMapping("{id}")
    public ResponseEntity<RespostaDto> deletarCliente(@PathVariable Long id){
        
        boolean retorno = clienteService.excluirCliente(id);
        
        RespostaDto resposta = new RespostaDto();
        resposta.setMensagem(retorno ? "Delete realizado com sucesso" : "Erro ao realizar delete");
        
        return ResponseEntity.status(HttpStatus.OK).body(resposta); 
    }
    
    
    @GetMapping()
    public ResponseEntity<List<ClienteModel>> obterCliente(){
        
        List<ClienteModel> lista = clienteService.obterLista();
        
        return ResponseEntity.status(HttpStatus.OK).body(lista); 
        
    }
    
}
