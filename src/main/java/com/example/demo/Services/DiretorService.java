package com.example.demo.Services;

import com.example.demo.Exceptions.CustomException;
import com.example.demo.Model.Diretor;
import com.example.demo.Repository.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DiretorService {
    @Autowired
    private DiretorRepository diretorRepository;

    public Diretor cadastrar(Diretor diretor) {
        if (!diretorRepository.existsByNome(diretor.getNome())) {
            diretorRepository.save(diretor);
            return diretor;
        } else {
            throw new CustomException("Este nome de diretor já está sendo usado", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
