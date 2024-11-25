package com.exemplo.leilao.controladores;

import com.exemplo.leilao.entidades.Produto;
import com.exemplo.leilao.repositorios.ProdutoRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

import java.math.BigDecimal;
import java.util.List;

@Controller("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Get("/filtrar")
    public List<Produto> filtrarProdutos(@QueryValue Long leilaoId, 
                                        @QueryValue BigDecimal valorMinimo, 
                                        @QueryValue BigDecimal valorMaximo, 
                                        @QueryValue BigDecimal valorTotalMinimo, 
                                        @QueryValue BigDecimal valorTotalMaximo, 
                                        @QueryValue String nomeProduto, 
                                        @QueryValue String tipoProduto) {
        return produtoRepository.findByLeilaoId(leilaoId, valorMinimo, valorMaximo, valorTotalMinimo, valorTotalMaximo, nomeProduto, tipoProduto);
    }
}
