package com.exemplo.leilao.repositorio;

import com.exemplo.leilao.entidades.Veiculo;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface VeiculoRepostirory extends JpaRepository<Veiculo, Long>{
    
}
