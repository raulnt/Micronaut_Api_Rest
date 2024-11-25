package com.exemplo.leilao.servicos;

import com.exemplo.leilao.entidades.Veiculo;
import com.exemplo.leilao.repositorios.VeiculoRepository;
import jakarta.inject.Singleton;
import java.util.List;

@Singleton
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    // Listar todos os veículos
    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll();
    }

    // Salvar um novo veículo
    public Veiculo salvarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    // Atualizar um veículo existente
    public Veiculo atualizarVeiculo(Veiculo veiculo) {
        return veiculoRepository.update(veiculo);
    }

    // Deletar um veículo
    public void deletarVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }
}
