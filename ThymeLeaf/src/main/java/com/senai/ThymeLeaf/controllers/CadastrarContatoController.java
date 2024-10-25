package com.senai.ThymeLeaf.controllers;

import com.senai.ThymeLeaf.dtos.ContatoDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class CadastrarContatoController {

    @GetMapping("/cadastrarusuario")
    public String exibirListaContatos(Model model) {

        ContatoDto contatoDto = new ContatoDto();

        model.addAttribute("contatoDto", contatoDto);

        return "cadastrarcontato";
    }

}
