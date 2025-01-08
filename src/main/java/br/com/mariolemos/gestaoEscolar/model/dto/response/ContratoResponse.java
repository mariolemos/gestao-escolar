package br.com.mariolemos.gestaoEscolar.model.dto.response;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Contato;
import br.com.mariolemos.gestaoEscolar.model.Contrato;
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
public class ContratoResponse {

    private Long id;
    private double valorContratual;
    private LocalDate dtPagamento;
    private String formaPagamento;
    private LocalDate dtInicial;
    private LocalDate dtFinal;
    private String responsavel;
    private Boolean ativo;
    //private List<Aluno> alunos = new ArrayList<>();

    public ContratoResponse(Contrato contrato){
        this.id = contrato.getId();
        this.valorContratual = contrato.getValorContratual();
        this.dtPagamento = contrato.getDtPagamento();
        this.dtPagamento = contrato.getDtPagamento();
        this.formaPagamento = contrato.getFormaPagamento();
        this.dtInicial = contrato.getDtInicial();
        this.dtFinal = contrato.getDtFinal();
        this.ativo = contrato.getAtivo();

        if (contrato.getResponsavel() != null) {
            this.responsavel = contrato.getResponsavel().getNome();
        }

    }


    public static List<ContratoResponse> of(List<Contrato> contratos) {
        return contratos.stream().map(contr -> new ContratoResponse(contr)).collect(Collectors.toList());
    }
}
