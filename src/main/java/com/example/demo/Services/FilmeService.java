package com.example.demo.Services;

import com.example.demo.Exceptions.CustomException;
import com.example.demo.Model.Filme;
import com.example.demo.Model.PageConfig;
import com.example.demo.Repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> EncontrarPorDiretor(int diretorID) { return  filmeRepository.findByDiretor_IdOrderByNome(diretorID); }

    public List<Filme> EncontrarPorGenero(int generoID) {
        return  filmeRepository.findByGenero_IdOrderByNome(generoID);
    }

    public Page<Filme> TodosOsFilmes(PageConfig pageConfig) {
        Pageable pageable = PageRequest.of(pageConfig.getPageNumber(), pageConfig.getPageSize());

        return  filmeRepository.findAll(pageable);
    }

    public List<Filme> EncontrarPorNome(String nome) {
        return filmeRepository.findByNomeContainsOrderByNome(nome);
    }

    public List<Filme> EncontrarPorId(int id) {
        return filmeRepository.findById(id);
    }
    public Filme Cadastrar(Filme filme){
        if (!filmeRepository.existsByNome(filme.getNome())) {
            filmeRepository.save(filme);
            return filme;
        } else {
            throw new CustomException("Este nome de filme já está sendo usado", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
