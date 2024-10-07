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

    public boolean cadastrarCliente(ClienteDto novoCliente) {

        ClienteModel cliente = new ClienteModel();

        cliente.setNome(novoCliente.getNome());
        cliente.setEmail(novoCliente.getEmail());
        cliente.setTelefone(novoCliente.getTelefone());
        cliente.setDataCadastro(LocalDate.now());
        cliente.setEndereco(novoCliente.getEndereco());
        cliente.setNumeroEndereco(novoCliente.getNumeroEndereco());

        repositorio.save(cliente);

        return true;

    }

    public boolean atualizarCliente(ClienteDto novoCliente, String email) {

        Optional<ClienteModel> optionalCliente = obterUsuarioPorEMail(email);

        if (!optionalCliente.isPresent()) {

            return false;

        }

        ClienteModel cliente = optionalCliente.get();
        cliente.setNome(novoCliente.getNome());
        cliente.setEmail(novoCliente.getEmail());
        cliente.setTelefone(novoCliente.getTelefone());
        cliente.setDataCadastro(LocalDate.now());
        cliente.setEndereco(novoCliente.getNome());
        cliente.setNumeroEndereco(novoCliente.getNumeroEndereco());

        repositorio.save(cliente);

        return true;

    }

    public Optional<ClienteModel> obterUsuarioPorEMail(String email) {

        Optional<ClienteModel> optionalCliente = repositorio.findByEmail(email);

        return optionalCliente;

    }

    public List<ClienteModel> obterClientes() {

        List<ClienteModel> lista = repositorio.findAll();

        return lista;

    }

    public boolean excluirCliente(Long codigo) {

        Optional<ClienteModel> optionalCliente = repositorio.findById(codigo);

        if (optionalCliente.isPresent()) {

            repositorio.deleteById(codigo);
            return true;

        }

        return false;

    }

}
