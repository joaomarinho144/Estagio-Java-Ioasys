package com.example.demo.Repository;

import com.example.demo.Model.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiretorRepository extends JpaRepository<Diretor, Integer> {
    boolean existsByNome(String nome);
}
