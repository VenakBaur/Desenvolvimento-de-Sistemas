package com.senai.login.repository;

import com.senai.login.models.UsuarioModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    
    public Optional<UsuarioModel> findByLogin(String email);
    
}