package com.example.demo.Model;


import javax.persistence.*;

@Entity
@Table(name="avaliacoes")
public class Avaliacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = false, nullable = false)
    private int nota;

    @Column(unique = false, nullable = false)
    private int filmes_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getFilmes_id() {
        return filmes_id;
    }

    public void setFilmes_id(int filmes_id) {
        this.filmes_id = filmes_id;
    }

}
