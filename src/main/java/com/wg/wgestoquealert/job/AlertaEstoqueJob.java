package com.wg.wgestoquealert.job;

import com.wg.wgestoquealert.client.VanguardClient;
import com.wg.wgestoquealert.dto.ProdutoVariacaoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlertaEstoqueJob {

    private static final Logger log = LoggerFactory.getLogger(AlertaEstoqueJob.class);

    private final VanguardClient vanguardClient;
    private final long limite;

    public AlertaEstoqueJob(VanguardClient vanguardClient,
                            @Value("${alerta.estoque.limite}") long limite) {
        this.vanguardClient = vanguardClient;
        this.limite = limite;
    }

    @Scheduled(fixedDelayString = "${alerta.estoque.intervalo-ms}")
    public void verificarEstoque() {
        try {
            List<ProdutoVariacaoDTO> baixos = vanguardClient.buscarEstoqueBaixo(limite);

            if (baixos.isEmpty()) {
                log.info("Estoque OK: nenhuma variação com {} unidades ou menos.", limite);
                return;
            }

            for (ProdutoVariacaoDTO v : baixos) {
                log.warn("ALERTA DE ESTOQUE BAIXO: {} ({}, {}) está com {} unidade(s).",
                        v.produto().nome(), v.cor(), v.tamanho(), v.estoque());
            }
        } catch (Exception e) {
            log.error("Não foi possível consultar o WG Vanguard: {}", e.getMessage());
        }
    }
}