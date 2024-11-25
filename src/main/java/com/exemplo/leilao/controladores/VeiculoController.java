package com.exemplo.leilao.controladores;

import com.exemplo.leilao.entidades.Veiculo;
import com.exemplo.leilao.servicos.VeiculoService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import java.util.List;

@Controller("/veiculos")
public class VeiculoController {

    @Inject
    VeiculoService veiculoService;

    // Listar todos os veículos
    @Get("/")
    public List<Veiculo> listar() {
        return veiculoService.listarVeiculos();
    }

    // Salvar um novo veículo
    @Post("/")
    public Veiculo salvar(@Body Veiculo veiculo) {
        return veiculoService.salvarVeiculo(veiculo);
    }

    // Atualizar um veículo existente
    @Put("/{id}")
    public Veiculo atualizar(@Body Veiculo veiculo, @PathVariable Long id) {
        veiculo.setId(id);
        return veiculoService.atualizarVeiculo(veiculo);
    }

    // Deletar um veículo
    @Delete("/{id}")
    public void deletar(@PathVariable Long id) {
        veiculoService.deletarVeiculo(id);
    }
}
