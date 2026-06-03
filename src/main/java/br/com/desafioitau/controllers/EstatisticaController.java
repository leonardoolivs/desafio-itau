package br.com.desafioitau.controllers;

import br.com.desafioitau.entities.Estatistica;
import br.com.desafioitau.service.EstatisticaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticaController {

    private final EstatisticaService service;

    @GetMapping
    public ResponseEntity<Estatistica> stats(){
        return ResponseEntity.ok(service.obterEstatisticas());
    }
}
