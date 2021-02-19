package com.example.demo.Services;

import com.example.demo.Exceptions.CustomException;
import com.example.demo.Model.Genero;
import com.example.demo.Repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository generoRepository;

    public Genero cadastrar(Genero genero) {
        if (!generoRepository.existsByNome(genero.getNome())) {
            generoRepository.save(genero);
            return genero;
        } else {
            throw new CustomException("Este nome de genero já está sendo usado", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
