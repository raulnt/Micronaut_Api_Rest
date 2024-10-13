package com.exemplo.leilao.repositorio;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import com.exemplo.leilao.entidades.Leilao;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Long> {
}