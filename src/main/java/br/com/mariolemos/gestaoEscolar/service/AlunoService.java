package br.com.mariolemos.gestaoEscolar.service;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Pessoa;
import br.com.mariolemos.gestaoEscolar.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> buscar(){
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos;
    }

    public Aluno incluir(Aluno aluno){
        return alunoRepository.save(aluno);
    }

}
