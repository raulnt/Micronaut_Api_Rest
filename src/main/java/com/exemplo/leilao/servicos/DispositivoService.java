package com.exemplo.leilao.servicos;

import com.exemplo.leilao.entidades.Dispositivo;
import com.exemplo.leilao.repositorios.DispositivoRepository;
import jakarta.inject.Singleton;
import java.util.List;

@Singleton
public class DispositivoService {

    private final DispositivoRepository dispositivoRepository;

    public DispositivoService(DispositivoRepository dispositivoRepository) {
        this.dispositivoRepository = dispositivoRepository;
    }

    // Listar todos os dispositivos
    public List<Dispositivo> listarDispositivos() {
        return dispositivoRepository.findAll();
    }

    // Salvar um novo dispositivo
    public Dispositivo salvarDispositivo(Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    // Atualizar um dispositivo existente
    public Dispositivo atualizarDispositivo(Dispositivo dispositivo) {
        return dispositivoRepository.update(dispositivo);
    }

    // Deletar um dispositivo
    public void deletarDispositivo(Long id) {
        dispositivoRepository.deleteById(id);
    }
}
