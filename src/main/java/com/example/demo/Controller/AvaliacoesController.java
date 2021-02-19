package com.example.demo.Controller;

import com.example.demo.Dto.Avaliacoes.AvaliacoesDataDTO;
import com.example.demo.Model.Avaliacoes;
import com.example.demo.Services.AvaliacoesService;
import io.swagger.annotations.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacoes")
@Api(tags = "avaliacoes")
public class AvaliacoesController {
    @Autowired
    private AvaliacoesService avaliacoesService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/Avaliar")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @ApiOperation(value = "${AvaliacoesController.Avaliar}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied")})
    public Avaliacoes Avaliar(@ApiParam("Avaliar Filme") @RequestBody AvaliacoesDataDTO avaliacoes) {
        return avaliacoesService.cadastrar(modelMapper.map(avaliacoes, Avaliacoes.class));
    }
}
