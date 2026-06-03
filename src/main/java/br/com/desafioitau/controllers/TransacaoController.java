package br.com.desafioitau.controllers;

import br.com.desafioitau.entities.Transacao;
import br.com.desafioitau.repositories.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {

    private final TransacaoRepository repository;

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody Transacao transacao){
        transacao = repository.save(transacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping
    public void deletarTudo(){
        repository.deleteAll();
    }


}
