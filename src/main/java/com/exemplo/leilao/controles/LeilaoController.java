package com.exemplo.leilao.controles;

import com.exemplo.leilao.entidades.Leilao;
import com.exemplo.leilao.repositorio.LeilaoRepository;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import java.util.List;

@Controller("/leiloes")
public class LeilaoController {

    @Inject
    LeilaoRepository leilaoRepository;

    @Get("/")
    public List<Leilao> listar() {
        return leilaoRepository.findAll();
    }

    @Post("/")
    public Leilao salvar(@Body Leilao leilao) {
        return leilaoRepository.save(leilao);
    }

    @Put("/{id}")
    public Leilao atualizar(@Body Leilao leilao, @PathVariable Long id) {
        leilao.setId(id);
        return leilaoRepository.update(leilao);
    }

    @Delete("/{id}")
    public void deletar(@PathVariable Long id) {
        leilaoRepository.deleteById(id);
    }
}