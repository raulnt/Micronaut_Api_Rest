package com.exemplo.leilao.servicos;

import io.micronaut.context.annotation.Service;
import javax.transaction.Transactional;
import com.exemplo.leilao.model.Leilao;
import java.util.List;
import java.util.Optional;

@Service
public class LeilaoService {

    // Método para listar todos os leilões
    public List<Leilao> listarTodos() {
        // Lógica para listar todos os leilões
        return Leilao.findAll().list();
    }

    // Método para buscar leilão por ID
    public Optional<Leilao> buscarPorId(Long id) {
        // Lógica para buscar leilão por ID
        return Leilao.findById(id);
    }

    // Método para criar um novo leilão
    @Transactional
    public Leilao criar(Leilao leilao) {
        // Lógica para criar leilão
        leilao.persist();
        return leilao;
    }

    // Método para atualizar leilão existente
    @Transactional
    public Leilao atualizar(Long id, Leilao leilao) {
        // Lógica para atualizar leilão
        Optional<Leilao> leilaoExistente = Leilao.findById(id);
        if (leilaoExistente.isPresent()) {
            Leilao l = leilaoExistente.get();
            l.setNome(leilao.getNome());
            l.setDescricao(leilao.getDescricao());
            l.setDataInicio(leilao.getDataInicio());
            l.setDataFim(leilao.getDataFim());
            l.update();
            return l;
        }
        return null;
    }

    // Método para excluir leilão
    @Transactional
    public boolean excluir(Long id) {
        // Lógica para excluir leilão
        Optional<Leilao> leilao = Leilao.findById(id);
        if (leilao.isPresent()) {
            leilao.get().delete();
            return true;
        }
        return false;
    }
}
