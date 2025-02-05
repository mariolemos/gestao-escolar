package br.com.mariolemos.gestaoEscolar.service;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Contrato;
import br.com.mariolemos.gestaoEscolar.model.Responsavel;
import br.com.mariolemos.gestaoEscolar.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ResponsavelService responsavelService;

    public List<Contrato> buscar(){
        List<Contrato> contratos = contratoRepository.findAll();
        return contratos;
    }

    public Contrato incluir(Contrato contrato){
        this.validarAlunosExistente(contrato);
        contrato.calcularMensalidade();

        return contratoRepository.save(contrato);
    }

    private void validarAlunosExistente(Contrato contrarto){
        Responsavel responsavel = responsavelService.buscarPorId(contrarto.getResponsavel().getId());

        List<String> alunos = new ArrayList<String>();

        contrarto.getAlunos().forEach( alunoId->{
            responsavel.getAlunos().forEach(aluno -> {

                if(alunoId.equals(aluno.getId())){
//                    throw new IllegalArgumentException("Alunos Não pertence a este Responsável");
                    alunos.add(aluno.getNome());
                }


            });

        });



        contrarto.setListaAlunos(String.join("," , alunos));
    }


}
