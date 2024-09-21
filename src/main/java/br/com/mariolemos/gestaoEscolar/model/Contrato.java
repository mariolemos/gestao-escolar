package br.com.mariolemos.gestaoEscolar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private double valorContratual;
    private LocalDate dtPagamento;
    private String formaPagamento;
    private LocalDate dtInicial;
    private LocalDate dtFinal;
    @ManyToOne
    private Responsavel responsavel;
    @OneToMany
    private List<Aluno> alunos = new ArrayList<>();

    public Contrato calcularMensalidade(double valor){
        return null;
    }

}
