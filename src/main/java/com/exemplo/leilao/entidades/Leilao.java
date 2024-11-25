package com.exemplo.leilao.entidades;

import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import com.exemplo.leilao.enums.StatusLeilao; // Importando o enum

import java.time.LocalDateTime;

@Entity
@Introspected
public class Leilao {

    @Id
    private Long id;

    private String nome;

    private LocalDateTime dataOcorrencia; // Data e hora do leilão

    @Enumerated(EnumType.STRING) // Enum armazena o valor como String no banco
    private StatusLeilao status; // Status do leilão

    // Construtor padrão (necessário para JPA)
    public Leilao() {
    }

    // Construtor com parâmetros
    public Leilao(Long id, String nome, LocalDateTime dataOcorrencia, StatusLeilao status) {
        this.id = id;
        this.nome = nome;
        this.dataOcorrencia = dataOcorrencia;
        this.status = status;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(LocalDateTime dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public StatusLeilao getStatus() {
        return status;
    }

    public void setStatus(StatusLeilao status) {
        this.status = status;
    }

    // Método para atualizar o status do leilão
    public void atualizarStatus() {
        // Exemplo de lógica de atualização do status baseado na data do leilão
        if (dataOcorrencia.isAfter(LocalDateTime.now())) {
            this.status = StatusLeilao.EM_ABERTO; // Leilão ainda não começou
        } else if (dataOcorrencia.isBefore(LocalDateTime.now()) && status != StatusLeilao.FINALIZADO) {
            this.status = StatusLeilao.EM_ANDAMENTO; // Leilão em andamento
        }
        // Adicione mais lógica de finalização do leilão se necessário
    }

    // Exibe informações do leilão quando o status for FINALIZADO
    public void exibirInformacoesLeilao() {
        if (this.status == StatusLeilao.FINALIZADO) {
            // Aqui, você pode adicionar a lógica de exibição dos clientes ganhadores e do lance vencedor.
            System.out.println("Leilão Finalizado!");
            // Exemplo fictício de exibição
            System.out.println("Cliente Ganhador: João");
            System.out.println("Lance Vencedor: R$ 5000");
        }
    }

    // Sobrescrevendo toString para melhor legibilidade
    @Override
    public String toString() {
        return "Leilao{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", dataOcorrencia=" + dataOcorrencia +
            ", status=" + status.getDescricao() +
            '}';
    }

    // Sobrescrevendo equals e hashCode (caso necessário para comparações)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leilao leilao = (Leilao) o;
        return id != null && id.equals(leilao.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
