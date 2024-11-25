package com.exemplo.leilao.controladores;

import com.exemplo.leilao.entidades.Dispositivo;
import com.exemplo.leilao.servicos.DispositivoService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import java.util.List;

@Controller("/dispositivos")
public class DispositivoController {

    @Inject
    DispositivoService dispositivoService;

    // Listar todos os dispositivos
    @Get("/")
    public List<Dispositivo> listar() {
        return dispositivoService.listarDispositivos();
    }

    // Salvar um novo dispositivo
    @Post("/")
    public Dispositivo salvar(@Body Dispositivo dispositivo) {
        return dispositivoService.salvarDispositivo(dispositivo);
    }

    // Atualizar um dispositivo existente
    @Put("/{id}")
    public Dispositivo atualizar(@Body Dispositivo dispositivo, @PathVariable Long id) {
        dispositivo.setId(id);
        return dispositivoService.atualizarDispositivo(dispositivo);
    }

    // Deletar um dispositivo
    @Delete("/{id}")
    public void deletar(@PathVariable Long id) {
        dispositivoService.deletarDispositivo(id);
    }
}
