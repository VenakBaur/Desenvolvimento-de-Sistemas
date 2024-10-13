package com.senai.login.controllers;

import com.senai.login.dtos.LoginDto;
import com.senai.login.dtos.*;
import com.senai.login.models.UsuarioModel;
import com.senai.login.services.UsuarioService;
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
public class UsuarioController {
    
    //--Injeção de dependencia do usuárioService
    @Autowired
    private UsuarioService usuarioService;    
    
    //--Mapeia a rota para /usuario/login para acessar o recurso de autenticar
    @PostMapping("/login")
    public ResponseEntity<RespostaDto> realizarLogin(@RequestBody LoginDto login){
        //-- recebe como parâmetro o LoginDto e retorna LoginRespostaDto
        
        boolean retorno = usuarioService.autenticarUsuario(login);
        
        RespostaDto resposta = new RespostaDto();
        resposta.setMensagem(retorno ? "Login realizado com sucesso" : "Erro ao realizar login");
                
        //--Realiza retorno com a resposta 
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(resposta);
    }
    
    @PostMapping("/usuario")
    public  ResponseEntity<RespostaDto> cadastrarUsuario(@RequestBody CadastroDto cadastro){
        
        boolean retorno = usuarioService.cadastrarUsuario(cadastro);
        
        RespostaDto resposta = new RespostaDto();
        resposta.setMensagem(retorno ? "Cadastro realizado com sucesso" : "Erro ao realizar cadastro");
        
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
        
    }
    
    //-- PUT http://localhost:8080/usuario/admin
    @PutMapping("/usuario/{login}")
    public  ResponseEntity<RespostaDto> atualizarUsuario(@RequestBody CadastroDto cadastro, @PathVariable String login){
        
        boolean retorno = usuarioService.atualizarUsuario(cadastro, login);
        
        RespostaDto resposta = new RespostaDto();
        resposta.setMensagem(retorno ? "Atualização realizado com sucesso" : "Erro ao realizar atualização");
        
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }
    
    //-- DELETE http://localhost:8080/usuario/4
    @DeleteMapping("/usuario/{codigo}")
    public ResponseEntity<RespostaDto> deletarUsuario(@PathVariable Long codigo){
        
        boolean retorno = usuarioService.excluirUsuario(codigo);
        
        RespostaDto resposta = new RespostaDto();
        resposta.setMensagem(retorno ? "Delete realizado com sucesso" : "Erro ao realizar delete");
        
        return ResponseEntity.status(HttpStatus.OK).body(resposta); 
    }
    
    
    @GetMapping("/usuario")
    public ResponseEntity<List<UsuarioModel>> obterUsuarios(){
        
        List<UsuarioModel> lista = usuarioService.obterUsuarios();
        
        return ResponseEntity.status(HttpStatus.OK).body(lista); 
        
    }
    
}
