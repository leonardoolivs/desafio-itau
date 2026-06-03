package br.com.desafioitau.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {

    private Double valor;
    private LocalDateTime dataHora = LocalDateTime.now();
}
