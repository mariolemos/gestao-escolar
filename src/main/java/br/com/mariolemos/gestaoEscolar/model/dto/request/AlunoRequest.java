package br.com.mariolemos.gestaoEscolar.model.dto.request;


import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Colegio;
import br.com.mariolemos.gestaoEscolar.model.Responsavel;
import br.com.mariolemos.gestaoEscolar.model.dto.PessoaDto;
import br.com.mariolemos.gestaoEscolar.model.dto.response.AlunoResponse;
import br.com.mariolemos.gestaoEscolar.model.dto.response.ContatoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoRequest extends PessoaDto {

    private String turno;
    private String serie;
    private String turma;
    private String nomeDaMae;
    private String nomeDoPai;
    private String convenioMedico;
    private Boolean ativo;
    private Long responsavelId;
    private Long colegioId;
    private List<ContatoRequest> contatos = new ArrayList<ContatoRequest>();

    public static Aluno of(AlunoRequest alunoRequest){
        Aluno aluno = new Aluno();

        Responsavel responsavel = new Responsavel();
        responsavel.setId(alunoRequest.getResponsavelId());

        Colegio colegio = new Colegio();
        colegio.setId(alunoRequest.getColegioId());

        aluno.setNome(alunoRequest.getNome());
        aluno.setTurno(alunoRequest.getTurno());
        aluno.setSerie(alunoRequest.getSerie());
        aluno.setTurma(alunoRequest.getTurma());
        aluno.setNomeDaMae(alunoRequest.getNomeDaMae());
        aluno.setNomeDoPai(alunoRequest.getNomeDoPai());
        aluno.setConvenioMedico(alunoRequest.getConvenioMedico());
        aluno.setCpf(alunoRequest.getCpf());
        aluno.setRg(alunoRequest.getRg());
        aluno.setDtNascimento(alunoRequest.getDtNascimento());
        aluno.setColegio(colegio);
        aluno.setResponsavel(responsavel);
        aluno.setContatos(ContatoRequest.of(alunoRequest.getContatos()));

       return aluno;
    }


    public static List<Aluno> of(List<AlunoRequest> alunosRequest) {
        return alunosRequest.stream().map(AlunoRequest::of).collect(Collectors.toList());
    }

}
