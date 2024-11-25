package com.exemplo.leilao.servicos;

import com.exemplo.leilao.entidades.Dispositivo;
import com.exemplo.leilao.entidades.Leilao;
import com.exemplo.leilao.entidades.Veiculo;
import com.exemplo.leilao.enums.StatusLeilao;
import com.exemplo.leilao.repositorios.DispositivoRepository;
import com.exemplo.leilao.repositorios.LeilaoRepository;
import com.exemplo.leilao.repositorios.VeiculoRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class ProdutoService {

    @Inject
    DispositivoRepository dispositivoRepository;

    @Inject
    VeiculoRepository veiculoRepository;

    @Inject
    LeilaoRepository leilaoRepository;

    // Registrar um dispositivo com o leilão associado
    public Dispositivo registrarDispositivo(Long leilaoId, Dispositivo dispositivo) {
        Leilao leilao = dispositivo.getLeilao();
        dispositivo.setLeilao(leilao);
        return dispositivoRepository.save(dispositivo);
    }

    // Registrar um veículo com o leilão associado
    public Veiculo registrarVeiculo(Long leilaoId, Veiculo veiculo) {
        Leilao leilao = veiculo.getLeilao();
        veiculo.setLeilao(leilao);
        return veiculoRepository.save(veiculo);
    }

    // Desassociar um produto (dispositivo ou veículo) de um leilão
    public void desassociarProdutoDeLeilao(Long produtoId, boolean isDispositivo) {
        if (isDispositivo) {
            Dispositivo dispositivo = dispositivoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
            if (dispositivo.getLeilao() != null && dispositivo.getLeilao().getStatus() != StatusLeilao.FINALIZADO) {
                dispositivo.setLeilao(null);
                dispositivoRepository.update(dispositivo);
            } else {
                throw new RuntimeException("Produto já foi vendido ou não está mais disponível para desassociar");
            }
        } else {
            Veiculo veiculo = veiculoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
            if (veiculo.getLeilao() != null && veiculo.getLeilao().getStatus() != StatusLeilao.FINALIZADO) {
                veiculo.setLeilao(null);
                veiculoRepository.update(veiculo);
            } else {
                throw new RuntimeException("Produto já foi vendido ou não está mais disponível para desassociar");
            }
        }
    }
}
