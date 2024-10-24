package com.senai.ThymeLeaf.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CONTATO")
@Data
public class ContatoModel {

    @Id
    @Column(name = "id_contato")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 90)
    private String nome;

    @Column(name = "telefone", nullable = false, length = 90)
    private String telefone;

    @Column(name = "email", nullable = false, length = 90)
    private String email;

    @Column(name = "endereco", nullable = false, length = 90)
    private String endereco;

    @Column(name = "CPF/CNPJ", nullable = false, length = 90)
    private String CPFCNPJ;

}
