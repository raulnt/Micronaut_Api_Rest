package com.exemplo.leilao.repositorios;

import com.exemplo.leilao.entidades.Dispositivo;
import com.exemplo.leilao.entidades.Leilao;

import io.micronaut.core.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LeilaoRepository {
    private List<Leilao> leiloes;

    public LeilaoRepository() {
        leiloes = new ArrayList<>();
    }

    // CREATE
    public void salvarLeilao(Leilao leilao) {
        leiloes.add(leilao);
    }

    // READ
    public Optional<Leilao> buscarLeilaoPorId(Long id) {
        return leiloes.stream()
                    .filter(leilao -> leilao.getId().equals(id))
                    .findFirst();
    }

    // UPDATE
    public boolean atualizarLeilao(Long id, Leilao leilaoAtualizado) {
        for (int i = 0; i < leiloes.size(); i++) {
            if (leiloes.get(i).getId().equals(id)) {
                leiloes.set(i, leilaoAtualizado);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean removerLeilao(Long id) {
        return leiloes.removeIf(leilao -> leilao.getId().equals(id));
    }

    // Listar todos os leilões
    public List<Leilao> listarLeiloes() {
        return new ArrayList<>(leiloes);
    }

    public Optional<Dispositivo> findById(Long leilaoId) {
      // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
