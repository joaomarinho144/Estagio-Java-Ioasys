package com.example.demo.Repository;

import com.example.demo.Model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {
    boolean existsByNome(String nome);
}
