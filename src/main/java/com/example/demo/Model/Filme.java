package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name="filmes")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = false, nullable = false)
    private String nome;

    @Column(unique = false, nullable = false)
    private int totaldeestrelas;

    @Column(unique = false, nullable = false)
    private int numerodevotos;

    @Column(unique = false, nullable = false)
    private double media;

    //...
    @ManyToOne
    @JoinColumn(name="genero_Id", nullable=false)
    private Genero genero;

    //...
    @ManyToOne
    @JoinColumn(name="Diretor_Id", nullable=false)
    private Diretor diretor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTotaldeestrelas() {
        return totaldeestrelas;
    }

    public void setTotaldeestrelas(int totaldeestrelas) {
        this.totaldeestrelas = totaldeestrelas;
    }

    public int getNumerodevotos() {
        return numerodevotos;
    }

    public void setNumerodevotos(int numerodevotos) {
        this.numerodevotos = numerodevotos;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }
}
