package com.wg.wgestoquealert.dto;

import java.math.BigDecimal;

public record ProdutoVariacaoDTO(long id, ProdutoDTO produto, String cor,
                                 String tamanho, BigDecimal valorTotal, long estoque) {

    public record ProdutoDTO(long id, String nome, String tipo) {}
}