package br.com.mariolemos.gestaoEscolar.model.dto.response;

import br.com.mariolemos.gestaoEscolar.enumerations.FormaPagamento;
import br.com.mariolemos.gestaoEscolar.model.Contrato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoResponse {

    private Long id;
    private BigDecimal valorContratual;
    private LocalDate dtPagamento;
    private FormaPagamento formaPagamento;
    private LocalDate dtInicial;
    private LocalDate dtFinal;
    private String responsavel;
    private Boolean ativo;
    private BigDecimal valorMensal;
    private List<String> alunos = new ArrayList<>();

    public ContratoResponse(Contrato contrato){
        this.id = contrato.getId();
        this.valorContratual = contrato.getValorContratual();
        this.dtPagamento = contrato.getDtPagamento();
        this.formaPagamento = contrato.getFormaPagamento();
        this.dtInicial = contrato.getDtInicial();
        this.dtFinal = contrato.getDtFinal();
        this.ativo = contrato.getAtivo();
        this.valorMensal = contrato.getValorMensal();
        this.alunos = Arrays.stream(contrato.getListaAlunos().split(",")).toList();

        if (contrato.getResponsavel() != null) {
            this.responsavel = contrato.getResponsavel().getNome();
        }

    }


    public static List<ContratoResponse> of(List<Contrato> contratos) {
        return contratos.stream().map(contr -> new ContratoResponse(contr)).collect(Collectors.toList());
    }
}
