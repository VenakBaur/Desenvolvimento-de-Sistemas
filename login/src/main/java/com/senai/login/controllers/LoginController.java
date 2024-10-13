package com.senai.login.controllers;

import com.senai.login.dtos.LoginDto;
import com.senai.login.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UsuarioService usuarioservice;
    
    @GetMapping("/")
    public String viewLogin(Model model) {

        LoginDto loginDto = new LoginDto();
        loginDto.setLogin("marlos");
        loginDto.setSenha("senha123");
        model.addAttribute("loginDto", loginDto);

        return "login";

    }

    @PostMapping("/autenticar")
    public String autenticar(Model model, @ModelAttribute LoginDto loginDto) {

        System.out.println("login=" + loginDto.getLogin() + " senha=" + loginDto.getSenha());

        boolean retorno = usuarioservice.autenticarUsuario(loginDto);
        
        if (retorno == true) {
            
            return "redirect:/home";
            
        }
        
        return "login";
        
    }

}
