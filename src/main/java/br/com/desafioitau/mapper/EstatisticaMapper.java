package br.com.desafioitau.mapper;

import br.com.desafioitau.entities.Estatistica;
import org.springframework.stereotype.Component;

import java.util.DoubleSummaryStatistics;

@Component
public class EstatisticaMapper {

    public Estatistica from(DoubleSummaryStatistics stats){
        return new Estatistica(
                stats.getCount(),
                stats.getSum(),
                stats.getAverage(),
                stats.getMin(),
                stats.getMax());
    }
}
