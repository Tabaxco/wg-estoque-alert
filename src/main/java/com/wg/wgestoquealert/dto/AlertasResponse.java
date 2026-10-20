package com.wg.wgestoquealert.dto;

import java.time.LocalDateTime;
import java.util.List;

public record AlertasResponse(LocalDateTime atualizadoEm, List<ProdutoVariacaoDTO> alertas) {}