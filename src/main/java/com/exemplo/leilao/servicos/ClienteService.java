package com.exemplo.leilao.servicos;

import com.exemplo.leilao.entidades.Cliente;
import com.exemplo.leilao.repositorios.ClienteRepository;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Registra um novo cliente
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Consulta todos os clientes
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // Consulta um cliente pelo ID
    public Optional<Cliente> consultarCliente(Long id) {
        return clienteRepository.findById(id);
    }

    // Atualiza um cliente
    public Cliente atualizarCliente(Cliente cliente, Long id) {
        cliente.setId(id);
        return clienteRepository.update(cliente);
    }

    // Remove um cliente
    public void removerCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
