package com.example.demo.Controller;

import com.example.demo.Dto.Filme.FilmeDataDTO;
import com.example.demo.Model.Filme;
import com.example.demo.Model.PageConfig;
import com.example.demo.Services.FilmeService;
import io.swagger.annotations.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@Api(tags = "filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping(value = "/BuscarPorNome/{nome}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @ApiOperation(value = "${FilmeController.BuscarPorNome}", response = Filme.class, authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public List<Filme> BuscarPorNome(@ApiParam("nome") @PathVariable String nome) {
        return filmeService.EncontrarPorNome(nome);
    }

    @GetMapping(value = "/BuscarPorId/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @ApiOperation(value = "${FilmeController.BuscarPorId}", response = Filme.class, authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public List<Filme> BuscarPorId(@ApiParam("id") @PathVariable int id) {
        return filmeService.EncontrarPorId(id);
    }

    @GetMapping(value = "/BuscarPorDiretor/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @ApiOperation(value = "${FilmeController.BuscarPorDiretor}", response = Filme.class, authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public List<Filme> BuscarPorDiretor(@ApiParam("id") @PathVariable int id) {
        return filmeService.EncontrarPorDiretor(id);
    }

    @GetMapping(value = "/BuscarPorGenero/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @ApiOperation(value = "${FilmeController.BuscarPorGenero}", response = Filme.class, authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public List<Filme> BuscarPorGenero(@ApiParam("id") @PathVariable int id) {
        return filmeService.EncontrarPorGenero(id);
    }

    @PostMapping("/cadastrarFilme")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${FilmeController.cadastrarFilme}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Este nome de filme já está sendo usadoe")})
    public Filme cadastrarFilme(@ApiParam("Cadastrar Filme") @RequestBody FilmeDataDTO filme) {
        return filmeService.Cadastrar(modelMapper.map(filme, Filme.class));
    }

    @PostMapping("/TodosOsFilmes")
    @ApiOperation(value = "${FilmeController.TodosOsFilmes}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Este nome de filme já está sendo usadoe")})
    public ResponseEntity<Page<Filme>> TodosOsFilmes(PageConfig pageConfig) {
        return new ResponseEntity<>(filmeService.TodosOsFilmes(pageConfig), HttpStatus.OK);
    }
}
