package com.wg.wgestoquealert.controller;

import com.wg.wgestoquealert.dto.AlertasResponse;
import com.wg.wgestoquealert.store.AlertaStore;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alertas")
public class AlertaController {

    private final AlertaStore alertaStore;

    public AlertaController(AlertaStore alertaStore) {
        this.alertaStore = alertaStore;
    }

    @GetMapping
    public AlertasResponse listar() {
        return new AlertasResponse(alertaStore.getAtualizadoEm(), alertaStore.getAlertas());
    }
}