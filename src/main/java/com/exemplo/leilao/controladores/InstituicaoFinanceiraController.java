package com.exemplo.leilao.controladores;

import com.exemplo.leilao.entidades.InstituicaoFinanceira;
import com.exemplo.leilao.servicos.InstituicaoFinanceiraServico;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import java.util.List;

@Controller("/instituicoes-financeiras")
public class InstituicaoFinanceiraController {

    @Inject
    InstituicaoFinanceiraServico instituicaoFinanceiraServico;

    // Registrar uma instituição financeira
    @Post("/")
    public InstituicaoFinanceira registrar(@Body InstituicaoFinanceira instituicaoFinanceira) {
        return instituicaoFinanceiraServico.registrarInstituicao(instituicaoFinanceira);
    }

    // Listar todas as instituições financeiras
    @Get("/")
    public List<InstituicaoFinanceira> listar() {
        return instituicaoFinanceiraServico.listarInstituicoes();
    }

    // Atualizar uma instituição financeira
    @Put("/{id}")
    public InstituicaoFinanceira atualizar(@PathVariable Long id, @Body InstituicaoFinanceira instituicaoFinanceira) {
        return instituicaoFinanceiraServico.atualizarInstituicao(id, instituicaoFinanceira);
    }

    // Remover uma instituição financeira
    @Delete("/{id}")
    public void remover(@PathVariable Long id) {
        instituicaoFinanceiraServico.removerInstituicao(id);
    }
}
