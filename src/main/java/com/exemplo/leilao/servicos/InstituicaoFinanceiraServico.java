package com.exemplo.leilao.servicos;

import com.exemplo.leilao.entidades.InstituicaoFinanceira;
import com.exemplo.leilao.repositorios.InstituicaoFinanceiraRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.List;

@Singleton
public class InstituicaoFinanceiraServico {

    @Inject
    InstituicaoFinanceiraRepository instituicaoFinanceiraRepository;

    // Registrar uma instituição financeira
    public InstituicaoFinanceira registrarInstituicao(InstituicaoFinanceira instituicaoFinanceira) {
        return instituicaoFinanceiraRepository.save(instituicaoFinanceira);
    }

    // Listar todas as instituições financeiras
    public List<InstituicaoFinanceira> listarInstituicoes() {
        return instituicaoFinanceiraRepository.findAll();
    }

    // Atualizar uma instituição financeira
    public InstituicaoFinanceira atualizarInstituicao(Long id, InstituicaoFinanceira instituicaoFinanceira) {
        instituicaoFinanceira.setId(id);
        return instituicaoFinanceiraRepository.update(instituicaoFinanceira);
    }

    // Remover uma instituição financeira
    public void removerInstituicao(Long id) {
        instituicaoFinanceiraRepository.deleteById(id);
    }
}
