package com.exemplo.leilao.controladores;

import com.exemplo.leilao.entidades.Cliente;
import com.exemplo.leilao.servicos.ClienteService;
import io.micronaut.http.annotation.*;

import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;

@Controller("/clientes")
public class ClienteController {

    @Inject
    private ClienteService clienteService;

    // Endpoint para listar todos os clientes
    @Get("/")
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    // Endpoint para salvar um novo cliente
    @Post("/")
    public Cliente salvarCliente(@Body Cliente cliente) {
        return clienteService.salvarCliente(cliente);
    }

    // Endpoint para consultar um cliente por ID
    @Get("/{id}")
    public Optional<Cliente> consultarCliente(@PathVariable Long id) {
        return clienteService.consultarCliente(id);
    }

    // Endpoint para atualizar um cliente
    @Put("/{id}")
    public Cliente atualizarCliente(@Body Cliente cliente, @PathVariable Long id) {
        return clienteService.atualizarCliente(cliente, id);
    }

    // Endpoint para remover um cliente
    @Delete("/{id}")
    public void removerCliente(@PathVariable Long id) {
        clienteService.removerCliente(id);
    }
}
