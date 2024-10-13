package com.exemplo.leilao.entidades;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "leiloes")
@Data
@Serdeable
public class Leilao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataOcorrencia;
    private LocalDate dataVisitacao;
    private String local;
    private String endereco;
    private String cidade;
    private String estado;

    public void setId(Long id) {
        this.id = id;
    }
}