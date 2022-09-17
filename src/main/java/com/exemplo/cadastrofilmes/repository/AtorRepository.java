package com.exemplo.cadastrofilmes.repository;

import com.exemplo.cadastrofilmes.domain.Ator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtorRepository extends JpaRepository<Ator, Long> {
    public Optional<Ator> findAtorByNome(String nome);

}
