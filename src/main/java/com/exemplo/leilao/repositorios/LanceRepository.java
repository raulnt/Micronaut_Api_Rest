package com.exemplo.leilao.repositorios;

import com.exemplo.leilao.entidades.Lance;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface LanceRepository extends CrudRepository<Lance, Long> {

    // Método para buscar lances de um produto específico, ordenados pelo ID do lance
    List<Lance> findByProdutoIdOrderById(Long produtoId);
}
