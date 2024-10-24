package com.senai.ThymeLeaf.controllers;

import com.senai.ThymeLeaf.dtos.CadastroDto;
import com.senai.ThymeLeaf.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @PostMapping()
    public String cadastrarUsuario(@ModelAttribute("usuario") CadastroDto cadastro){
        
        boolean sucesso = usuarioService.cadastrarUsuario(cadastro);
        
        if (sucesso){
            return "redirect:listausuarios";
        }

        return "redirect:cadastrarusuario?erro";        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  excluirUsuario(@PathVariable Long id){
    
        boolean sucesso = usuarioService.excluirUsuario(id);
        
        if (sucesso){
            return ResponseEntity.ok("Usuário excluído com sucesso.");
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir usuário.");
        
    }
}
