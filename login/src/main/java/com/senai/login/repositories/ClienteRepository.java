package com.senai.login.repositories;

import com.senai.login.models.ClienteModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    public Optional<ClienteModel> findByEmail(String email);

}
