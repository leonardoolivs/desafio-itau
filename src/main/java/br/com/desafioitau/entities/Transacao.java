package br.com.desafioitau.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_TRANSACAO")
public class Transacao {

    private Double valor;
    private LocalDateTime dataHora = LocalDateTime.now();
}
