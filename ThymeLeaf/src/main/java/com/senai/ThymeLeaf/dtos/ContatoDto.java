package com.senai.ThymeLeaf.dtos;

import lombok.Data;

@Data
public class ContatoDto {

    private Long id;

    private String nome;

    private String telefone;
    
    private String email;

    private String endereco;

    private String CPFCNPJ;

}
