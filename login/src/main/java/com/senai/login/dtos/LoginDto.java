package com.senai.login.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class LoginDto {

   @NotEmpty
   @NotNull
   private String login;
   
   @NotEmpty
   @NotNull
   private String senha;

    public LoginDto() {
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
