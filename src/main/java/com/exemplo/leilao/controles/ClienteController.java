package com.exemplo.leilao.controles;

import com.exemplo.leilao.entidades.Cliente;
import com.exemplo.leilao.repositorio.ClienteRepository;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import java.util.List;

@Controller("/clientes")
public class ClienteController {

    @Inject
    ClienteRepository clienteRepository;

    @Get("/")
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Post("/")
    public Cliente salvar(@Body Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Put("/{id}")
    public Cliente atualizar(@Body Cliente cliente, @PathVariable Long id) {
        cliente.setId(id);
        return clienteRepository.update(cliente);
    }

    @Delete("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
}