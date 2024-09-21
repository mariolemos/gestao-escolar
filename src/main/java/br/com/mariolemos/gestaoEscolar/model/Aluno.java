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
public class Aluno extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String turno;
    private String serie;
    private String turma;
    private String nomeDaMae;
    private String nomeDoPai;
    private String convencioMedico;
    @ManyToOne
    private Responsavel responsavel;
    //private Colegio colegio;
}
