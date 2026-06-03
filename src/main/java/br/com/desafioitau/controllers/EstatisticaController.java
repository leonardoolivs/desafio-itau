package br.com.desafioitau.controllers;

import br.com.desafioitau.entities.Estatistica;
import br.com.desafioitau.service.EstatisticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
@Tag(name = "Estatísticas", description = "API de Estatisticas")
public class EstatisticaController {

    private final Logger logger = LoggerFactory.getLogger(EstatisticaController.class);

    private final EstatisticaService service;

    @GetMapping
    @Operation(summary = "Retorna as transações feitas nos ultimos 60 segundos")
    public ResponseEntity<Estatistica> stats(@PathParam("tempo") Long tempo){
        logger.info("Pegando as ultimas transações dos ultimos 60 segundos");

        return ResponseEntity.ok(service.obterEstatisticas(tempo));
    }
}
