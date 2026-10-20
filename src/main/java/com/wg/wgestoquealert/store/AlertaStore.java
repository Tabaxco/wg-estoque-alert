package com.wg.wgestoquealert.store;

import com.wg.wgestoquealert.dto.ProdutoVariacaoDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class AlertaStore {

    private volatile List<ProdutoVariacaoDTO> alertas = List.of();
    private volatile LocalDateTime atualizadoEm;

    public void atualizar(List<ProdutoVariacaoDTO> novosAlertas) {
        this.alertas = List.copyOf(novosAlertas);
        this.atualizadoEm = LocalDateTime.now();
    }

    public List<ProdutoVariacaoDTO> getAlertas() {
        return alertas;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }
}