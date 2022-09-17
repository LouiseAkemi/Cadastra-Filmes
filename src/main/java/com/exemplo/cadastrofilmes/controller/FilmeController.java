package com.exemplo.cadastrofilmes.controller;

import com.exemplo.cadastrofilmes.domain.Filme;
import com.exemplo.cadastrofilmes.service.FilmeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/filmes")
@AllArgsConstructor
public class FilmeController {

    private final FilmeService filmeService;

    @PostMapping
    public ResponseEntity<Filme> adicionarFilme(@RequestBody Filme filme){
        filmeService.adicionarFilme(filme);
        return new ResponseEntity<>(filme, HttpStatus.CREATED);
    }

    @GetMapping("/id")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Long id){
        Filme filme = filmeService.buscarPorId(id);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

    @GetMapping("/titulo")
    public ResponseEntity<Filme> buscarPorTitulo(@PathVariable String titulo){
        Filme filme = filmeService.buscarPorTitulo(titulo);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

    @GetMapping("/genero")
    public ResponseEntity<List<Filme>> buscarPorGenero(@PathVariable String genero){
        List<Filme> filme = filmeService.buscarPorGenero(genero);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

    @GetMapping("/anoLancamento")
    public ResponseEntity<List<Filme>> buscarPorAnoLancamento(@PathVariable String anoLancamento){
        List<Filme> listaFilmes = filmeService.buscarPorAnoLancamento(anoLancamento);
        return new ResponseEntity<>(listaFilmes, HttpStatus.OK);
    }

    @GetMapping("/ator")
    public ResponseEntity<List<Filme>> buscarPorAtor(@PathVariable String ator){
        List<Filme> listaFilmes = filmeService.buscarPorAtor(ator);
        return new ResponseEntity<>(listaFilmes, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Filme>> listarFilmes(){
        List<Filme> listaFilmes = filmeService.listarFilmes();
        return new ResponseEntity<>(listaFilmes, HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Filme> removerPorId(@PathVariable Long id){
        Filme filme = filmeService.removerPorId(id);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

}
