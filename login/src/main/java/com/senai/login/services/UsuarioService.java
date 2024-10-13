package com.senai.login.services;

import com.senai.login.dtos.*;
import com.senai.login.models.UsuarioModel;
import com.senai.login.repositories.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
    Método Usuário service, usado para realizar operações com o usuário!
*/
@Service
public class UsuarioService {
    
    //--Injeção de dependencia do repositorio do usuário
    @Autowired
    UsuarioRepository repositorio;
    
    //--Método para realizar a autenticação do usuário
    //-- Parâmetro de entrada: LoginDto{ login, senha }
    //-- Retorno:   true: usuário autenticado com sucesso
    //--            false: usuário não encontrado ou senha incorreta
    public boolean autenticarUsuario(LoginDto login){
        
        //--busca usuário no repositorio (banco de dados) por login
        //-- Aqui será realizado o "select * from usuario where usuario_login = "admin";
        Optional<UsuarioModel> optionalUsuario = obterUsuarioPorLogin(login.getLogin());
        
        //--Teste do optional, se encontrou o usuário, testa a senha do usuário recuperada do banco de dados com o a senha informada na requisição
        if (optionalUsuario.isPresent()){
            if(optionalUsuario.get().getSenha().equals(login.getSenha())){
                //--Senha correta, retorna verdadeiro
                return true;
            }
        } 
        //--Não encontrou o usuário ou a senha esta incorreta!
        return false;        
    }   
    
    //--Método para realizar o cadastro de usuário
    //-- Parâmetro de entrada: CadastroDto{ nome, login e senha }
    //-- Retorno:   true: usuário cadastrado com sucesso
    //--            false: usuário não cadastrado
    public boolean cadastrarUsuario(CadastroDto cadastro){
        
        //--instanciar objeto model        
        UsuarioModel usuario = new UsuarioModel();
        
        //--Atribui valores vindos da requisição para o objeto model
        usuario.setNome(cadastro.getNome());
        usuario.setLogin(cadastro.getLogin());
        usuario.setSenha(cadastro.getSenha());
        
        //--Realiza a gravação no banco de dados
        repositorio.save(usuario);
        
        //--Retorna true
        return true;
        
    }
    
    //--Método para realizar a atualização de usuário
    //-- Parâmetro de entrada: CadastroDto{ nome, login e senha }
    //-- Retorno:   true: usuário atualizado com sucesso
    //--            false: usuário não encontrado e não atualizado
    public boolean atualizarUsuario(CadastroDto cadastro, String login){
    
        //--busca usuário no repositorio (banco de dados) por login
        //-- Aqui será realizado o "select * from usuario where usuario_login = "admin"; 
       Optional<UsuarioModel> optionalUsuario = obterUsuarioPorLogin(login);

       if (!optionalUsuario.isPresent()){
           return false;
       }
       
        UsuarioModel usuario = optionalUsuario.get();
        usuario.setNome(cadastro.getNome());
        usuario.setLogin(cadastro.getLogin());
        usuario.setSenha(cadastro.getSenha());
        
        repositorio.save(usuario);
        
        return true;
    }    
    
    //--Método para realizar a exclusão do usuário
    //-- Parâmetro de entrada: Long{ codigo }
    //-- Retorno:   true: usuário excluído com sucesso
    //--            false: usuário não não excluído e não encontrado
    public boolean excluirUsuario(Long codigo){
        
        Optional<UsuarioModel> optionalUsuario = repositorio.findById(codigo);
        
        if (optionalUsuario.isPresent()){
            repositorio.deleteById(codigo);        
            return true;
        }      
                
        return false;
    }
    
    public List<UsuarioModel> obterUsuarios(){
        
        List<UsuarioModel> lista = repositorio.findAll();
        
        return lista;
        
    }
    
    //--Método para realizar a busca do usuário no repositório
    //-- Parâmetro de entrada: String { login }
    //-- Retorno:   Optional<UsuarioModel>
    private Optional<UsuarioModel> obterUsuarioPorLogin(String login){
        
        //--busca usuário no repositorio (banco de dados) por login
        //-- Aqui será realizado o "select * from usuario where usuario_login = "admin"; 
        Optional<UsuarioModel> optionalUsuario = repositorio.findByLogin(login);
     
        return optionalUsuario;
    }
    
    
}
