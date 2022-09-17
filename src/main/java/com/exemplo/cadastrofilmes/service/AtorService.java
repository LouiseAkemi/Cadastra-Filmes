package com.exemplo.cadastrofilmes.service;

import com.exemplo.cadastrofilmes.domain.Ator;
import com.exemplo.cadastrofilmes.repository.AtorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AtorService {

    private final AtorRepository atorRepository;

    public Ator adicionarAtor(Ator ator){
        return atorRepository.save(ator);
    }

    public List<Ator> listarAtores(){
        return atorRepository.findAll();
    }

    public Ator buscarPorIdAtor(Long id){
        Optional<Ator> filmeById = atorRepository.findById(id);
        if (filmeById.isEmpty()){
            throw new IllegalArgumentException("Esse id eh invalido!");
        }
        return filmeById.get();
    }

     public Ator buscarPorNomeAtor(String ator) {
        Optional<Ator> filmeByAtor= atorRepository.findAtorByNome(ator);
        if (filmeByAtor.isEmpty()) {
            throw new IllegalArgumentException("Esse genero eh invalido!");
        }
        return filmeByAtor.get();

     }

    public Ator removerAtorPorId(Long id){
        Ator ator = buscarPorIdAtor(id);
        atorRepository.delete(ator);
        return ator;
    }

}
