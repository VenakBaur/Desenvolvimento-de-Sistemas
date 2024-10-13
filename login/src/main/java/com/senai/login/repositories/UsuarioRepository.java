package com.senai.login.repositories;

import com.senai.login.models.UsuarioModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{
    
    //--Metodo que irá forçar a classe JpaRepository<UsuarioModel, Long> 
    //--implementar o select * from Usuario where UsuarioLogin = 'admin'
    public Optional<UsuarioModel> findByLogin(String login);
    
}
