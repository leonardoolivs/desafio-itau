package br.com.desafioitau.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/health")
@Tag(name = "Health Checker")
public class HealthCheckerController {

    @GetMapping
    @Operation(summary = "Confere se a API esta UP")
    public ResponseEntity<Map<String, String>> health(){
        return ResponseEntity.ok(Map.of("status", "UP"));
    }

}
