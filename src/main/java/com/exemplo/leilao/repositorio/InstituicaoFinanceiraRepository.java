package com.exemplo.leilao.repositorio;

import com.exemplo.leilao.entidades.InstituicaoFinanceira;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface InstituicaoFinanceiraRepository extends JpaRepository<InstituicaoFinanceira, Long> {
}