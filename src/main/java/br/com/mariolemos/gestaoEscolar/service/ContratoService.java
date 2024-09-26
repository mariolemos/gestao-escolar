package br.com.mariolemos.gestaoEscolar.service;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Contrato;
import br.com.mariolemos.gestaoEscolar.repository.AlunoRepository;
import br.com.mariolemos.gestaoEscolar.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    public List<Contrato> buscar(){
        List<Contrato> contratos = contratoRepository.findAll();
        return contratos;
    }

    public Contrato incluir(Contrato contrato){
        return contratoRepository.save(contrato);
    }

}
