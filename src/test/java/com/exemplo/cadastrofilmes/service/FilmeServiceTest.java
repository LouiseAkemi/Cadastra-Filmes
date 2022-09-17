package com.exemplo.cadastrofilmes.service;

import com.exemplo.cadastrofilmes.domain.Ator;
import com.exemplo.cadastrofilmes.domain.Filme;
import com.exemplo.cadastrofilmes.repository.AtorRepository;
import com.exemplo.cadastrofilmes.repository.FilmeRepository;
import org.hibernate.collection.internal.PersistentBag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class FilmeServiceTest {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private AtorRepository atorRepository;

    @Autowired
    private FilmeService filmeService;

    @BeforeEach
    public void limpaBanco() {
        filmeRepository.deleteAll();
    }

    @Test
    @DisplayName("Testar adicionar filmes na camada service")
    public void adicionarFilmesTest(){
        Ator ator1 = atorRepository.save(Ator.builder().nome("Tom Cruise").build());
        Ator ator2 = atorRepository.save(Ator.builder().nome("Miles Teller").build());
        Ator ator3 = atorRepository.save(Ator.builder().nome("Jennifer Connelly").build());

        Filme filme = Filme.builder()
                .titulo("Top Gun: Maverick")
                .genero("Ação")
                .anoLancamento("2022")
                .ator(List.of(
                        ator1, ator2, ator3
                ))
                .build();

        Filme filmeAdicionado = filmeService.adicionarFilme(filme);

        List<Filme> listaFilmes = filmeService.listarFilmes();

        // O filme foi adicionado na lista?
        Assertions.assertEquals(1,listaFilmes.size());

        // O filme construido eh o mesmo add?
        Assertions.assertEquals(filme, filmeAdicionado);

//        System.out.println("Texto"+filmeAdicionado.getAtor());

    }

    @Test
    @DisplayName("Testar buscar com Id")
    public void buscarPorIdTeste(){

        Filme filme = Filme.builder()
                .titulo("Top Gun: Maverick")
                .genero("Ação")
                .anoLancamento("2022")
                .ator(List.of(
                        atorRepository.save(Ator.builder().nome("Tom Cruise").build()),
                        atorRepository.save(Ator.builder().nome("Miles Teller").build()),
                        atorRepository.save(Ator.builder().nome("Jennifer Connelly").build())
                ))
                .build();

        Filme filmeAdicionado = filmeService.adicionarFilme(filme);

        Filme filmeEncontrado = filmeService.buscarPorId(1L);

        // o mesmo adicionado eh o encontrado?
        Assertions.assertEquals(filmeAdicionado.getTitulo(),filmeEncontrado.getTitulo());
        Assertions.assertEquals(filmeAdicionado.getGenero(),filmeEncontrado.getGenero());
        Assertions.assertEquals(filmeAdicionado.getAnoLancamento(),filmeEncontrado.getAnoLancamento());
    }

    @Test
    @DisplayName("Testar buscar por Genero")
    public void buscarPorGeneroTeste(){

        Filme filme1 = Filme.builder()
                .titulo("Top Gun: Maverick")
                .genero("Ação")
                .anoLancamento("2022")
                .ator(List.of(
                        atorRepository.save(Ator.builder().nome("Tom Cruise").build()),
                        atorRepository.save(Ator.builder().nome("Miles Teller").build()),
                        atorRepository.save(Ator.builder().nome("Jennifer Connelly").build())
                ))
                .build();

        Filme filme2 = Filme.builder()
                .titulo("Thor: Amor e Trovão")
                .genero("Ação")
                .anoLancamento("2022")
                .ator(List.of(
                        atorRepository.save(Ator.builder().nome("Chris Hemsworth").build()),
                        atorRepository.save(Ator.builder().nome("Natalie Portman").build()),
                        atorRepository.save(Ator.builder().nome("Christian Bale").build())
                ))
                .build();

        Filme filme3 = Filme.builder()
                .titulo("A Cinco Passos de Você")
                .genero("Drama")
                .anoLancamento("2019")
                .ator(List.of(
                        atorRepository.save(Ator.builder().nome("Haley Lu Richardson").build()),
                        atorRepository.save(Ator.builder().nome("Cole Sprouse").build()),
                        atorRepository.save(Ator.builder().nome("Moises Arias").build())
                ))
                .build();


        Filme filme1Adicionado = filmeService.adicionarFilme(filme1);
        Filme filme2Adicionado = filmeService.adicionarFilme(filme2);
        Filme filme3Adicionado = filmeService.adicionarFilme(filme3);

        List<Filme> filmesEncontrados = filmeService.buscarPorGenero("Ação");

        // Retorna uma lista de 2 elementos?
        Assertions.assertEquals(2,filmesEncontrados.size());

        // São os mesmos add?
        Assertions.assertEquals(filme1Adicionado.getTitulo(),filmesEncontrados.get(0).getTitulo());
        Assertions.assertEquals(filme2Adicionado.getTitulo(),filmesEncontrados.get(1).getTitulo());

        // Os filmes da filtrados são do mesmo genero selecionado?
        Assertions.assertEquals("Ação",filmesEncontrados.get(0).getGenero());
        Assertions.assertEquals("Ação",filmesEncontrados.get(1).getGenero());
    }


    @Test
    @DisplayName("Testar buscar por Genero")
    public void buscarPorAnoLancamentoTeste(){

        Filme filme1 = Filme.builder()
                .titulo("Top Gun: Maverick")
                .genero("Ação")
                .anoLancamento("2022")
                .ator(List.of(
                        atorRepository.save(Ator.builder().nome("Tom Cruise").build()),
                        atorRepository.save(Ator.builder().nome("Miles Teller").build()),
                        atorRepository.save(Ator.builder().nome("Jennifer Connelly").build())
                ))
                .build();

        Filme filme2 = Filme.builder()
                .titulo("Thor: Amor e Trovão")
                .genero("Ação")
                .anoLancamento("2022")
                .ator(List.of(
                        atorRepository.save(Ator.builder().nome("Chris Hemsworth").build()),
                        atorRepository.save(Ator.builder().nome("Natalie Portman").build()),
                        atorRepository.save(Ator.builder().nome("Christian Bale").build())
                ))
                .build();

        Filme filme3 = Filme.builder()
                .titulo("A Cinco Passos de Você")
                .genero("Drama")
                .anoLancamento("2019")
                .ator(List.of(
                        atorRepository.save(Ator.builder().nome("Haley Lu Richardson").build()),
                        atorRepository.save(Ator.builder().nome("Cole Sprouse").build()),
                        atorRepository.save(Ator.builder().nome("Moises Arias").build())
                ))
                .build();


        Filme filme1Adicionado = filmeService.adicionarFilme(filme1);
        Filme filme2Adicionado = filmeService.adicionarFilme(filme2);
        Filme filme3Adicionado = filmeService.adicionarFilme(filme3);

        List<Filme> filmesEncontrados = filmeService.buscarPorAnoLancamento("2022");

        // Retorna uma lista de 2 elementos?
        Assertions.assertEquals(2,filmesEncontrados.size());

        // São os mesmos add?
        Assertions.assertEquals(filme1Adicionado.getTitulo(),filmesEncontrados.get(0).getTitulo());
        Assertions.assertEquals(filme2Adicionado.getTitulo(),filmesEncontrados.get(1).getTitulo());

        // Os filmes da filtrados são do mesmo ano selecionado?
        Assertions.assertEquals("Ação",filmesEncontrados.get(0).getGenero());
        Assertions.assertEquals("Ação",filmesEncontrados.get(1).getGenero());
    }




}
