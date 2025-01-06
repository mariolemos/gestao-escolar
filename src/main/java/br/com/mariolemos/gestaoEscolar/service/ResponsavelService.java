package br.com.mariolemos.gestaoEscolar.service;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Responsavel;
import br.com.mariolemos.gestaoEscolar.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @Autowired
    private ContatoService contatoService;

    public List<Responsavel> buscar(){
        List<Responsavel> responsaveis = responsavelRepository.findAll();
        return responsaveis;
    }
    public Responsavel buscarPorId(Long id){
        return responsavelRepository.findById(id).orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
    }

    public Responsavel incluir(Responsavel responsavel){
        return responsavelRepository.save(responsavel);
    }
    @Transactional
    public Responsavel atualizar(Responsavel responsavel, Long id){
        Responsavel responsavel1 = buscarPorId(id);
        responsavel1.setNome(responsavel.getNome());
        responsavel1.setParentesco(responsavel.getParentesco());
        responsavel1.setAlunos(responsavel.getAlunos());
        contatoService.excluirContatosResponsavel(id);
        responsavel1.setContatos(responsavel.getContatos());
        return responsavelRepository.save(responsavel1);
    }

    public void excluir(Long id){
        responsavelRepository.deleteById(id);
    }


}
