package com.exemplo.leilao.controladores;

import com.exemplo.leilao.entidades.Leilao;
import com.exemplo.leilao.servicos.LeilaoService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import jakarta.inject.Inject;  // Usando Jakarta Inject em vez de javax.inject
import java.util.List;

@Controller("/leiloes")
public class LeilaoController {

    @Inject
    private LeilaoService leilaoService;

    // Endpoint para listar todos os leilões
    @Get
    public List<Leilao> listarLeiloes() {
        return leilaoService.listarTodos();
    }

    // Endpoint para buscar um leilão por ID
    @Get("/{id}")
    public HttpResponse<Leilao> buscarLeilao(@PathVariable Long id) {
        Leilao leilao = leilaoService.buscarPorId(id);
        if (leilao != null) {
            return HttpResponse.ok(leilao);
        } else {
            return HttpResponse.notFound();
        }
    }

    // Endpoint para criar um novo leilão
    @Post
    public HttpResponse<Leilao> criarLeilao(@Body Leilao leilao) {
        leilaoService.criar(leilao);
        return HttpResponse.created(leilao);
    }

    // Endpoint para atualizar um leilão existente
    @Put("/{id}")
    public HttpResponse<Leilao> atualizarLeilao(@PathVariable Long id, @Body Leilao leilao) {
        Leilao leilaoAtualizado = leilaoService.atualizar(id, leilao);
        if (leilaoAtualizado != null) {
            return HttpResponse.ok(leilaoAtualizado);
        } else {
            return HttpResponse.notFound();
        }
    }

    // Endpoint para excluir um leilão
    @Delete("/{id}")
    public HttpResponse<Void> excluirLeilao(@PathVariable Long id) {
        if (leilaoService.excluir(id)) {
            return HttpResponse.noContent();
        } else {
            return HttpResponse.notFound();
        }
    }
}
