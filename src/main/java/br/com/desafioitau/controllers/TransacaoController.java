package br.com.desafioitau.controllers;

import br.com.desafioitau.entities.Transacao;
import br.com.desafioitau.repositories.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {

    private final TransacaoRepository repository;

    @PostMapping
    public ResponseEntity<Void> cadastrar(Transacao transacao){
        transacao = repository.save(transacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }


}
