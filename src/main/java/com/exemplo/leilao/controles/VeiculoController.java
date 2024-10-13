package com.exemplo.leilao.controles;

import java.util.List;

import com.exemplo.leilao.entidades.Veiculo;
import com.exemplo.leilao.repositorio.VeiculoRepostirory;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/veiculos")
public class VeiculoController {
    
    @Inject
    VeiculoRepostirory VeiculoRepository;

    @Get("/")
    public List<Veiculo> listar(){
        return VeiculoRepository.findAll();
    }

    @Post("/")
    public Veiculo salvar(@Body Veiculo veiculo) {
        return VeiculoRepository.save(veiculo);
    }
}
