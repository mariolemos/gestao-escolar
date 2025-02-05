package br.com.mariolemos.gestaoEscolar.model.dto.request;

import br.com.mariolemos.gestaoEscolar.enumerations.FormaPagamento;
import br.com.mariolemos.gestaoEscolar.enumerations.TipoContato;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoRequest {

    private Long id;
    private BigDecimal valorContratual;
    private LocalDate dtPagamento;
    private int formaPagamento;
    private LocalDate dtInicial;
    private LocalDate dtFinal;
    private Long responsavelId;
    private Boolean ativo;

    private List<Long> alunos = new ArrayList<>();
    public  static Contrato of(ContratoRequest contratoRequest){

        Contrato contrato = new Contrato();
        contrato.setAtivo(contratoRequest.getAtivo());
        contrato.setDtInicial(contratoRequest.getDtInicial());
        contrato.setDtFinal(contratoRequest.getDtFinal());
        contrato.setDtPagamento(contratoRequest.getDtPagamento());
        contrato.setValorContratual(contratoRequest.getValorContratual());
        contrato.setFormaPagamento(FormaPagamento.find(contratoRequest.getFormaPagamento()));
        //contrato.setListaAlunos(String.join(", ", contratoRequest.getAlunos()));
        contrato.setAlunos(contratoRequest.getAlunos());
        contrato.setResponsavel(new Responsavel(contratoRequest.getResponsavelId()));
        return contrato;
    }

    public static List<Contrato> of(List<ContratoRequest> contratos) {
        return contratos.stream().map(ContratoRequest::of).collect(Collectors.toList());
    }

}
