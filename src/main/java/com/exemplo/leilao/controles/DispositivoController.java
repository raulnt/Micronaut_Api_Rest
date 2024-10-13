package com.exemplo.leilao.controles;

import com.exemplo.leilao.entidades.Dispositivo;
import com.exemplo.leilao.entidades.Leilao;
import com.exemplo.leilao.repositorio.DispositivoRepository;
import com.exemplo.leilao.repositorio.LeilaoRepository;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import java.util.List;

@Controller("/dispositivos")
public class DispositivoController {

    @Inject
    DispositivoRepository dispositivoRepository;

    @Inject
    LeilaoRepository leilaoRepository;

    @Get("/")
    public List<Dispositivo> listar() {
        return dispositivoRepository.findAll();
    }

    @Post("/")
    public Dispositivo salvar(@Body Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    @Put("/{id}")
    public Dispositivo atualizar(@Body Dispositivo dispositivo, @PathVariable Long id) {
        dispositivo.setId(id);
        return dispositivoRepository.update(dispositivo);
    }

    @Delete("/{id}")
    public void deletar(@PathVariable Long id) {
        dispositivoRepository.deleteById(id);
    }

    @Post("/{dispositivoId}/associar/{leilaoId}")
    public Dispositivo associarLeilao(@PathVariable Long dispositivoId, @PathVariable Long leilaoId) {
        Dispositivo dispositivo = dispositivoRepository.findById(dispositivoId).orElse(null);
        Leilao leilao = leilaoRepository.findById(leilaoId).orElse(null);
        if (dispositivo != null && leilao != null) {
            dispositivo.setLeilao(leilao);
            return dispositivoRepository.update(dispositivo);
        }
        return null;
    }
}
