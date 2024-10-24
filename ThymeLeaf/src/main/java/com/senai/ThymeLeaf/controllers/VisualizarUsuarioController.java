package com.senai.ThymeLeaf.controllers;

import com.senai.ThymeLeaf.dtos.UsuarioDto;
import com.senai.ThymeLeaf.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visualizarusuario")
public class VisualizarUsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/{id}")
    public String exibirVisualizarUsuario(Model model, @PathVariable Long id){

        UsuarioDto usuario = usuarioService.obterUsuario(id);
                
        model.addAttribute("usuarioDto", usuario);
        
        if (usuario.getId() > 0){
            return "visualizarusuario";
        }
        
        return "redirect:/listausuarios";
        
    }
    
}
