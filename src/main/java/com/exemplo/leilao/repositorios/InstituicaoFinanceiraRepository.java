package com.exemplo.leilao.repositorios;

import com.exemplo.leilao.entidades.InstituicaoFinanceira;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface InstituicaoFinanceiraRepository extends JpaRepository<InstituicaoFinanceira, Long> {
}