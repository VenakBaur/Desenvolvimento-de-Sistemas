package com.senai.login.repositories;

import com.senai.login.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<ClienteModel, Long>{
    
    
    
}
