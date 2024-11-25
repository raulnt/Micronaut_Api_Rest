package com.exemplo.leilao.controladores;

import com.exemplo.leilao.entidades.Lance;
import com.exemplo.leilao.repositorios.LanceRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.util.List;

@Controller("/lances")
public class LanceController {

    private final LanceRepository lanceRepository;

    public LanceController(LanceRepository lanceRepository) {
        this.lanceRepository = lanceRepository;
    }

    @Get("/produto/{produtoId}/historico")
    public HttpResponse<List<Lance>> listarHistoricoLances(@PathVariable Long produtoId) {
        List<Lance> historicoLances = lanceRepository.findByProdutoIdOrderById(produtoId);

        if (historicoLances.isEmpty()) {
            return HttpResponse.notFound(); // Retorna 404 se não houver lances para o produto
        }

        return HttpResponse.ok(historicoLances);
    }
}
