package com.exemplo.leilao.controles;

import com.exemplo.leilao.entidades.InstituicaoFinanceira;
import com.exemplo.leilao.repositorio.InstituicaoFinanceiraRepository;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import java.util.List;

@Controller("/instituicoes")
public class InstituicaoFinanceiraController {

    @Inject
    InstituicaoFinanceiraRepository instituicaoFinanceiraRepository;

    @Get("/")
    public List<InstituicaoFinanceira> listar() {
        return instituicaoFinanceiraRepository.findAll();
    }

    @Post("/")
    public InstituicaoFinanceira salvar(@Body InstituicaoFinanceira instituicaoFinanceira) {
        return instituicaoFinanceiraRepository.save(instituicaoFinanceira);
    }
}
