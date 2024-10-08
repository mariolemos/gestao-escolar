package br.com.mariolemos.gestaoEscolar.service;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Colegio;
import br.com.mariolemos.gestaoEscolar.repository.AlunoRepository;
import br.com.mariolemos.gestaoEscolar.repository.ColegioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColegioService {

    @Autowired
    private ColegioRepository colegioRepository;

    public List<Colegio> buscar(){
        List<Colegio> colegios = colegioRepository.findAll();
        return colegios;
    }
    public Colegio buscarPorId(Long id){
        return colegioRepository.findById(id).orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
    }

    public Colegio incluir(Colegio colegio){
        return colegioRepository.save(colegio);
    }
    public Colegio atualizar(Colegio colegio, Long id){
        Colegio colegio1 = buscarPorId(id);
        return colegioRepository.save(colegio1);
    }

    public void excluir(Long id){
        colegioRepository.deleteById(id);
    }

}
