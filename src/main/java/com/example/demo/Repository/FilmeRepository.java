package com.example.demo.Repository;

import com.example.demo.Model.Filme;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FilmeRepository extends PagingAndSortingRepository<Filme, Integer> {
    boolean existsByNome(String nome);
    List<Filme> findByDiretor_IdOrderByNome(int diretorID);
    List<Filme> findByGenero_IdOrderByNome(int generoID);
    List<Filme> findByNomeContainsOrderByNome(String nome);
    List<Filme> findById(int id);
}
