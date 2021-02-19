package com.example.demo.Dto.Genero;

import io.swagger.annotations.ApiModelProperty;

public class GeneroDataDTO {

    @ApiModelProperty(position = 0)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
