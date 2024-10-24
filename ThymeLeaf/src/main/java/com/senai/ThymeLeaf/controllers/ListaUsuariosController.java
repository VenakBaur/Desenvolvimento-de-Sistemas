package com.senai.ThymeLeaf.controllers;

import com.senai.ThymeLeaf.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class ListaUsuariosController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/listausuarios")
    public String exibirListaUsuarios(Model model){
                     
        model.addAttribute("usuarios",usuarioService.obterListaUsuarios());
        
        //--template : retorna o nome do arquivo html localizado lá na pasta templates.
        return "listausuarios";
    }
    
}
