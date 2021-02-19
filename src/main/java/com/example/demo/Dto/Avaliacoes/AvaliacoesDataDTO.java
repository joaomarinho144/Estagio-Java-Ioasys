package com.example.demo.Dto.Avaliacoes;

import io.swagger.annotations.ApiModelProperty;

public class AvaliacoesDataDTO {
    @ApiModelProperty(position = 0)
    private int nota;
    @ApiModelProperty(position = 1)
    private int filmes_id;

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
