package com.exemplo.cadastrofilmes.repository;

import com.exemplo.cadastrofilmes.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    Optional<Filme> findByTitulo(String titulo);

    Optional<List<Filme>> findByGenero(String genero);

    Optional<List<Filme>> findByAnoLancamento(String anoLancamento);

    Optional<List<Filme>> findByAtor(String ator);

}
