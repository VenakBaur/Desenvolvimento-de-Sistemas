package com.senai.login.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CadastroDto {
    @NotNull (message = "É necessário inserir o nome")
    @NotBlank (message = "É necessário inserir o nome")
    private String nome;
    @NotNull (message = "É necessário inserir o login")
    @NotBlank (message = "É necessário inserir o login")
    private String login;
    @NotNull (message = "É necessário inserir a senha")
    @NotBlank (message = "É necessário inserir a senha")
    private String senha;

    public CadastroDto() {
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
