package com.senai.login.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="CLIENTE")
public class ClienteModel {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigo;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="email")
    private String email;
    
    @Column(name="endereco")
    private String endereco;
    
    @Column(name="telefone")
    private String telefone;
    
    @Column(name="numero")
    private Integer numero;
    
    @Column(name="cadastro")
    private LocalDate cadastro;

    public ClienteModel() {
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public LocalDate getCadastro() {
        return cadastro;
    }

    public void setCadastro(LocalDate cadastro) {
        this.cadastro = cadastro;
    }
    
    
    
}
