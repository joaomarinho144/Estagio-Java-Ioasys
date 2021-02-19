package com.example.demo.Services;

import com.example.demo.Model.Avaliacoes;
import com.example.demo.Repository.AvaliacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacoesService {
    @Autowired
    private AvaliacoesRepository avaliacoesRepository;

    public Avaliacoes cadastrar(Avaliacoes avaliacoes) {
            avaliacoesRepository.save(avaliacoes);
            return avaliacoes;
    }
}
