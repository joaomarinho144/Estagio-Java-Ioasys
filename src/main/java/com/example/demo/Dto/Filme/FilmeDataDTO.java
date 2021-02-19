package com.example.demo.Dto.Filme;

import com.example.demo.Model.Diretor;
import com.example.demo.Model.Genero;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.JoinColumn;

public class FilmeDataDTO {
    @ApiModelProperty(position = 0)
    private String nome;
    @ApiModelProperty(position = 1)
    private int totaldeestrelas;
    @ApiModelProperty(position = 2)
    private int numerodevotos;
    @ApiModelProperty(position = 3)
    @JoinColumn(name="genero_Id", nullable=false)
    private Genero genero;
    @ApiModelProperty(position = 4)
    @JoinColumn(name="Diretor_Id", nullable=false)
    private Diretor Diretor;

    @ApiModelProperty(position = 5)
    private double media;

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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public com.example.demo.Model.Diretor getDiretor() {
        return Diretor;
    }

    public void setDiretor(com.example.demo.Model.Diretor diretor) {
        Diretor = diretor;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
}
