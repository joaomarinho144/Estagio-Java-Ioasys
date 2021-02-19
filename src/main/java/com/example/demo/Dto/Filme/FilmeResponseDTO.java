package com.example.demo.Dto.Filme;

import com.example.demo.Model.Diretor;
import com.example.demo.Model.Genero;
import io.swagger.annotations.ApiModelProperty;

public class FilmeResponseDTO {

    @ApiModelProperty(position = 0)
    private Integer id;
    @ApiModelProperty(position = 1)
    private String nome;
    @ApiModelProperty(position = 2)
    private int totaldeestrelas;
    @ApiModelProperty(position = 3)
    private int numerodevotos;
    @ApiModelProperty(position = 4)
    private int media;
    @ApiModelProperty(position = 5)
    Genero genero;
    @ApiModelProperty(position = 6)
    Diretor Diretor;

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

    public int getMedia() {
        return totaldeestrelas / numerodevotos;
    }

    public void setMedia(int media) {
        this.media = media;
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
}
