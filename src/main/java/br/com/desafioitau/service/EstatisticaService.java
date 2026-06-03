package br.com.desafioitau.service;

import br.com.desafioitau.entities.Estatistica;
import br.com.desafioitau.mapper.EstatisticaMapper;
import br.com.desafioitau.repositories.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.DoubleSummaryStatistics;

@Service
@RequiredArgsConstructor
public class EstatisticaService {

    private final EstatisticaMapper mapper;
    private final TransacaoRepository repository;

    @Transactional(readOnly = true)
    public Estatistica obterEstatisticas(){

        DoubleSummaryStatistics stats = repository.findAll()
                .stream()
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();

        return mapper.from(stats);

    }

}
