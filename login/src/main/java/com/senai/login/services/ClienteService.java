package com.senai.login.services;

import com.senai.login.dtos.ClienteDto;
import com.senai.login.models.ClienteModel;
import com.senai.login.repositories.ClienteRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository repositorio;
    
    public boolean cadastraCliente(ClienteDto dados){
        
        //--instanciar objeto model        
        ClienteModel cliente = new ClienteModel();
        
        //--Atribui valores vindos da requisição para o objeto model
        cliente.setNome(dados.getNome());
        cliente.setEmail(dados.getEmail());
        cliente.setEndereco(dados.getEndereco());
        cliente.setTelefone(dados.getTelefone());
        cliente.setNumero(dados.getNumero());
        cliente.setCadastro(LocalDate.now());
                
        //--Realiza a gravação no banco de dados
        repositorio.save(cliente);        
        
        return true;        
    } 
    
    
    public boolean atualizarCliente(Long id, ClienteDto dados){
        
        //--busca usuário no repositorio (banco de dados) por login
        //-- Aqui será realizado o "select * from usuario where usuario_login = "admin"; 
       Optional<ClienteModel> optionalCliente = repositorio.findById(id);

       if (!optionalCliente.isPresent()){
           return false;
       }
       
        ClienteModel cliente = optionalCliente.get();
        cliente.setNome(dados.getNome());
        cliente.setEmail(dados.getEmail());
        cliente.setEndereco(dados.getEndereco());
        cliente.setTelefone(dados.getTelefone());
        cliente.setNumero(dados.getNumero());            
        
        repositorio.save(cliente);        
        
        return true;
    }
    
    public boolean excluirCliente(Long id){
        
        Optional<ClienteModel> optionalCliente = repositorio.findById(id);
        
        if (optionalCliente.isPresent()){
            repositorio.deleteById(id);        
            return true;
        }      
                
        return false;
    }
    
    public List<ClienteModel> obterLista(){
        
        return repositorio.findAll();
        
    }
    
}

