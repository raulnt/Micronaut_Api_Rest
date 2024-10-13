package com.exemplo.leilao.entidades;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "dispositivos")
@Data
@Serdeable
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String marca;
    private String modelo;

    private Leilao leilao; // Associação com Leilao

    public void setId(Long id) {
        this.id = id;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }
}
