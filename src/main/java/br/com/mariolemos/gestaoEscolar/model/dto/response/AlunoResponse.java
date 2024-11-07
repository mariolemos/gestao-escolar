package br.com.mariolemos.gestaoEscolar.model.dto.response;

import br.com.mariolemos.gestaoEscolar.model.*;
import br.com.mariolemos.gestaoEscolar.model.dto.PessoaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoResponse extends PessoaDto {

    private Long id;
    private String turno;
    private String serie;
    private String turma;
    private String nomeDaMae;
    private String nomeDoPai;
    private String convenioMedico;
    private Boolean ativo;
    private String responsavel;
    private String colegio;

    public AlunoResponse(Aluno aluno){

        this.id = aluno.getId();
        this.turno = aluno.getTurno();
        this.serie = aluno.getSerie();
        this.turma = aluno.getTurma();
        this.nomeDoPai = aluno.getNomeDoPai();
        this.nomeDaMae = aluno.getNomeDaMae();
        this.convenioMedico = aluno.getConvenioMedico();
        this.ativo = aluno.getAtivo();
        super.setNome(aluno.getNome());

        if (aluno.getColegio() != null) {
            this.colegio = aluno.getColegio().getNome();
        }
        if (aluno.getResponsavel() != null) {
            this.responsavel = aluno.getResponsavel().getNome();
        }

    }

    public static List<AlunoResponse> of(List<Aluno> alunos) {
        return alunos.stream().map(alu -> new AlunoResponse(alu)).collect(Collectors.toList());
    }

}
