package com.example.Loja.Services;


import com.example.Loja.Exception.ClienteNotFoundException;

import com.example.Loja.Model.Cliente;
import com.example.Loja.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    public Cliente createCliente(Cliente Cliente) {
        return clienteRepository.save(Cliente);
    }

    public Cliente updateCliente(Long id, Cliente Cliente) {
        Cliente existingCliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
        existingCliente.setNome(Cliente.getNome());
        existingCliente.setCpf(Cliente.getCpf());
        return clienteRepository.save(existingCliente);
    }
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
