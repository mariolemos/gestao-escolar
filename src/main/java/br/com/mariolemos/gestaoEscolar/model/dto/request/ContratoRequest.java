package br.com.mariolemos.gestaoEscolar.model.dto.request;

import br.com.mariolemos.gestaoEscolar.enumerations.TipoContato;
import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Contato;
import br.com.mariolemos.gestaoEscolar.model.Responsavel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoRequest {

    private Long id;
    private double valorContratual;
    private LocalDate dtPagamento;
    private String formaPagamento;
    private LocalDate dtInicial;
    private LocalDate dtFinal;
    private Responsavel responsavel;
    private Boolean ativo;
    //private List<Aluno> alunos = new ArrayList<>();
    public  static Contato of(ContratoRequest contatoRequest){

        Contato contato = new Contato();


        return contato;
    }

    public static List<Contato> of(List<ContratoRequest> contatos) {
        return contatos.stream().map(ContratoRequest::of).collect(Collectors.toList());
    }

}
