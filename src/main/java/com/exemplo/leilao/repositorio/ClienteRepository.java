package com.exemplo.leilao.repositorio;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import com.exemplo.leilao.entidades.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}