package br.com.desafioitau.controllers;

import br.com.desafioitau.entities.Transacao;
import br.com.desafioitau.repositories.TransacaoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {

    private final Logger logger = LoggerFactory.getLogger(TransacaoController.class);
    private final TransacaoRepository repository;

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid Transacao transacao){
        logger.info("Transação iniciada");
        transacao = repository.save(transacao);

        logger.info("Transação finalizada com sucesso {}", transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping
    public void deletarTudo(){
        repository.deleteAll();
    }


}
