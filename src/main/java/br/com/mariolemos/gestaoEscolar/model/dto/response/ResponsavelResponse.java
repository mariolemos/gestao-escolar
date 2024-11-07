package br.com.mariolemos.gestaoEscolar.model.dto.response;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Contato;
import br.com.mariolemos.gestaoEscolar.model.Responsavel;
import br.com.mariolemos.gestaoEscolar.model.dto.PessoaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsavelResponse {

    private Long id;
    private String nome;
    private String parentesco;
    private List<Contato> contatos = new ArrayList<Contato>();
    private List<AlunoResponse> alunos = new ArrayList<>();

    public ResponsavelResponse(Responsavel responsavel){
        this.id = responsavel.getId();
        this.nome = responsavel.getNome();
        this.parentesco = responsavel.getParentesco();

        if (responsavel.getContatos() != null) {
            this.contatos = responsavel.getContatos();
        }
        if (responsavel.getAlunos() != null) {
            this.alunos = AlunoResponse.of(responsavel.getAlunos());
        }
    }


}
