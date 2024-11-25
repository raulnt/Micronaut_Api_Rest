package com.exemplo.leilao.repositorios;

import com.exemplo.leilao.entidades.Dispositivo;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
}
