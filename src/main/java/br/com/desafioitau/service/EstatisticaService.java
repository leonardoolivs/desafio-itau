package br.com.desafioitau.service;

import br.com.desafioitau.entities.Estatistica;
import br.com.desafioitau.mapper.EstatisticaMapper;
import br.com.desafioitau.repositories.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.DoubleSummaryStatistics;

@Service
@RequiredArgsConstructor
public class EstatisticaService {

    private final Integer TEMPO_ESTATISTICA = 60;

    private final EstatisticaMapper mapper;
    private final TransacaoRepository repository;

    @Transactional(readOnly = true)
    public Estatistica obterEstatisticas(){

        LocalDateTime segundos = LocalDateTime.now().minusSeconds(TEMPO_ESTATISTICA);

        DoubleSummaryStatistics stats = repository.findAll()
                .stream()
                .filter(t -> t.getDataHora().isAfter(segundos))
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();

        return mapper.from(stats);

    }

}
