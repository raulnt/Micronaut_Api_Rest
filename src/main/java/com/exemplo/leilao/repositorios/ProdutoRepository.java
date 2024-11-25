package com.exemplo.leilao.repositorios;

import com.exemplo.leilao.entidades.Produto;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.repository.CrudRepository;
import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    
    // Método customizado para filtrar produtos com base em diferentes parâmetros
    @Query("""
        SELECT p FROM Produto p
        WHERE (:leilaoId IS NULL OR p.leilao.id = :leilaoId)
        AND (:valorMinimo IS NULL OR p.lanceInicial >= :valorMinimo)
        AND (:valorMaximo IS NULL OR p.lanceInicial <= :valorMaximo)
        AND (:valorTotalMinimo IS NULL OR p.lanceInicial + p.lancesAdicionais >= :valorTotalMinimo)
        AND (:valorTotalMaximo IS NULL OR p.lanceInicial + p.lancesAdicionais <= :valorTotalMaximo)
        AND (:nomeProduto IS NULL OR p.nome LIKE %:nomeProduto%)
        AND (:tipoProduto IS NULL OR p.tipo = :tipoProduto)
    """)
    List<Produto> findByLeilaoId(Long leilaoId, 
                                  BigDecimal valorMinimo, 
                                  BigDecimal valorMaximo, 
                                  BigDecimal valorTotalMinimo, 
                                  BigDecimal valorTotalMaximo, 
                                  String nomeProduto, 
                                  String tipoProduto);
}
