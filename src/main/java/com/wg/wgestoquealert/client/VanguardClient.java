package com.wg.wgestoquealert.client;

import com.wg.wgestoquealert.dto.ProdutoVariacaoDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class VanguardClient {

    private final RestClient restClient;

    public VanguardClient(RestClient vanguardRestClient) {
        this.restClient = vanguardRestClient;
    }

    public List<ProdutoVariacaoDTO> buscarEstoqueBaixo(long limite) {
        return restClient.get()
                .uri("/produtosvariacao/estoque-baixo?limite={limite}", limite)
                .retrieve()
                .body(new ParameterizedTypeReference<List<ProdutoVariacaoDTO>>() {});
    }
}