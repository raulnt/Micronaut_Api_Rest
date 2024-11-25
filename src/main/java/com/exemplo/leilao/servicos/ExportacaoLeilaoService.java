package com.exemplo.leilao.servicos;

import com.exemplo.leilao.entidades.Leilao;
import com.fasterxml.jackson.databind.ObjectMapper; // Biblioteca para conversão para JSON
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ExportacaoLeilaoService {

    // Método para exportar os dados do leilão para o arquivo .DET
    public void exportarLeiloesParaDET(List<Leilao> leiloes, String caminhoArquivo) {
        // Criando um objeto ObjectMapper para converter os dados em JSON
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            // Convertendo os dados dos leilões para JSON
            String jsonLeiloes = objectMapper.writeValueAsString(leiloes);
            
            // Criando o arquivo .DET no caminho especificado
            File arquivo = new File(caminhoArquivo);
            
            // Escrevendo os dados JSON no arquivo
            objectMapper.writeValue(arquivo, leiloes);
            
            // Exibindo sucesso
            System.out.println("Dados exportados para " + caminhoArquivo);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao exportar dados para o arquivo .DET");
        }
    }
}
