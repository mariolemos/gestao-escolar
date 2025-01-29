package br.com.mariolemos.gestaoEscolar.model;

import br.com.mariolemos.gestaoEscolar.enumerations.FormaPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private double valorContratual;
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
//    @OneToMany
//    @JoinColumn(name = "ALUNO_ID")
//    private List<Aluno> alunos = new ArrayList<>();

    public Contrato calcularMensalidade(double valor){
        int parcelas;

//        Contrato contrato = new Contrato();
//
//        contrato.setValorContratual(valor);

       // parcelas = dtInicial.getMonthValue() - dtInicial.getMonthValue();

        //System.out.println(parcelas);

        return null;
    }

}
