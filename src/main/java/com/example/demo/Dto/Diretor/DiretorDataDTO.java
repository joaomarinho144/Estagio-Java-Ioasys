package com.example.demo.Dto.Diretor;

import io.swagger.annotations.ApiModelProperty;

public class DiretorDataDTO {
    @ApiModelProperty(position = 0)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
