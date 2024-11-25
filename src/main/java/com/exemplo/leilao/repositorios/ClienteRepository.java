package com.exemplo.leilao.repositorios;

import com.exemplo.leilao.entidades.Cliente;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
