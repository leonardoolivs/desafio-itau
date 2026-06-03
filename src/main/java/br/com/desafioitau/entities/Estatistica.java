package br.com.desafioitau.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estatistica {

    private Integer count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;
    
}
