package br.com.mariolemos.gestaoEscolar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PESSOA")
public class Aluno extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;
    @Column(name = "TURNO")
    private String turno;
    @Column(name = "SERIE")
    private String serie;
    @Column(name = "TURMA")
    private String turma;
    @Column(name = "NOME_DA_MAE")
    private String nomeDaMae;
    @Column(name = "NOME_DO_PAI")
    private String nomeDoPai;
    @Column(name = "CONVENIO_MEDICO")
    private String convencioMedico;
    @ManyToOne
    //@JoinColumn(name = "ALUNO_ID")
    private Responsavel responsavel;
    //private Colegio colegio;
}
