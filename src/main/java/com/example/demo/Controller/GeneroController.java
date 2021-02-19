package com.example.demo.Controller;

import com.example.demo.Dto.Genero.GeneroDataDTO;
import com.example.demo.Model.Genero;
import com.example.demo.Services.GeneroService;
import io.swagger.annotations.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generos")
@Api(tags = "generos")
public class GeneroController {
    @Autowired
    private GeneroService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/cadastrarGenero")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${GeneroController.cadastrarGenero}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Este nome de genero já está sendo usadoe")})
    public Genero cadastrarGenero(@ApiParam("Cadastrar Genero") @RequestBody GeneroDataDTO genero) {
        return userService.cadastrar(modelMapper.map(genero, Genero.class));
    }
}
