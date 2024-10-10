package com.senai.login.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class ClienteDto {

    private Long codigo;
    @NotNull (message = "É necessário inserir o nome")
    @NotBlank (message = "É necessário inserir o nome")
    private String nome;
    @NotNull (message = "É necessário inserir o email")
    @NotBlank (message = "É necessário inserir o email")
    @Email
    private String email;
    @NotNull (message = "É necessário inserir o telefone")
    @NotBlank (message = "É necessário inserir o telefone")
    private String telefone;
    
    private LocalDate dataCadastro;
    @NotNull (message = "É necessário inserir o endereco")
    @NotBlank (message = "É necessário inserir o endereco")
    private String endereco;
    @NotNull (message = "É necessário inserir o numero do endereco")
    @NotBlank (message = "É necessário inserir o numero do endereco")
    private Integer numeroEndereco;

    public ClienteDto() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(Integer numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

}
