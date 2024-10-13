package com.senai.login.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO")
public class UsuarioModel {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigo;
    
    @Column(name="UsuarioNome")
    private String nome;
    
    @Column(name="UsuarioLogin")
    private String login;
    
    @Column(name="UsuarioSenha")
    private String senha;   

    public UsuarioModel() {
    }

    public Long getId() {
        return codigo;
    }

    public void setId(Long id) {
        this.codigo = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
