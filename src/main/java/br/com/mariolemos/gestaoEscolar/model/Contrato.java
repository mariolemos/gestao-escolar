package br.com.mariolemos.gestaoEscolar.model;

import br.com.mariolemos.gestaoEscolar.enumerations.FormaPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONTRATO")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;
    @Column(name = "VALOR_CONTRATUAL")
    private BigDecimal valorContratual;
    @Column(name = "DATA_PAGAMENTO")
    private LocalDate dtPagamento;
    @Column(name = "FORMA_PAGAMENTO")
    @Enumerated(value = EnumType.STRING)
    private FormaPagamento formaPagamento;
    @Column(name = "DATA_INICIAL")
    private LocalDate dtInicial;
    @Column(name = "DATA_FINAL")
    private LocalDate dtFinal;
    @ManyToOne
    private Responsavel responsavel;
    @Column(name = "ATIVO")
    private Boolean ativo;
    private Integer diaPagamento;
    @Column(name = "VALOR_MENSAL")
    private BigDecimal valorMensal;
    @Column(name = "ALUNOS")
    private String listaAlunos;
    @Transient
    private List<Long> alunos = new ArrayList<Long>();

    public void calcularMensalidade(){
        int parcelas = dtFinal.getDayOfMonth() - dtInicial.getDayOfMonth() + 1;
        BigDecimal valorMensal = valorContratual;
        this.valorMensal = valorMensal.divide(new BigDecimal(parcelas));
    }

}
