package com.example.demo.Controller;

import com.example.demo.Dto.Diretor.DiretorDataDTO;
import com.example.demo.Model.Diretor;
import com.example.demo.Services.DiretorService;
import io.swagger.annotations.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diretores")
@Api(tags = "diretores")
public class DiretorController {
    @Autowired
    private DiretorService diretorService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/cadastrarDiretor")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${DiretorController.cadastrarDiretor}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Este nome de diretor já está sendo usadoe")})
    public Diretor cadastrarDiretor(@ApiParam("Cadastrar Diretor") @RequestBody DiretorDataDTO diretor) {
        return diretorService.cadastrar(modelMapper.map(diretor, Diretor.class));
    }
}
