package com.exemplo.cadastrofilmes.service;

import com.exemplo.cadastrofilmes.domain.Filme;
import com.exemplo.cadastrofilmes.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public Filme adicionarFilme(Filme filme){
        return filmeRepository.save(filme);
    }

    public List<Filme> listarFilmes(){
        return filmeRepository.findAll();
    }

    public Filme buscarPorId(Long id){
        Optional<Filme> filmeById = filmeRepository.findById(id);
        if (filmeById.isEmpty()){
            throw new IllegalArgumentException("Esse id eh invalido!");
        }
        return filmeById.get();
    }

    public Filme buscarPorTitulo(String titulo) {
        Optional<Filme> filmeByTitulo = filmeRepository.findByTitulo(titulo);
        if (filmeByTitulo.isEmpty()) {
            throw new IllegalArgumentException("Esse titulo eh invalido!");
        }
        return filmeByTitulo.get();
    }

    public List<Filme> buscarPorGenero(String genero) {
        Optional<List<Filme>> filmeByGenero = filmeRepository.findByGenero(genero);
        if (filmeByGenero.isEmpty()) {
            throw new IllegalArgumentException("Esse genero eh invalido!");
        }
        return filmeByGenero.get();
    }

    public List<Filme> buscarPorAnoLancamento(String anoLancamento) {
        Optional<List<Filme>> filmeByAnoLancamento = filmeRepository.findByAnoLancamento(anoLancamento);
        if (filmeByAnoLancamento.isEmpty()) {
            throw new IllegalArgumentException("Esse genero eh invalido!");
        }
        return filmeByAnoLancamento.get();
    }

    public List<Filme> buscarPorAtor(String ator) {
        Optional<List<Filme>> filmeByAtor= filmeRepository.findByAtor(ator);
        if (filmeByAtor.isEmpty()) {
            throw new IllegalArgumentException("Esse genero eh invalido!");
        }
        return filmeByAtor.get();
    }

    public Filme removerPorId(Long id){
        Filme filme = buscarPorId(id);
        filmeRepository.delete(filme);
        return filme;
    }





}
