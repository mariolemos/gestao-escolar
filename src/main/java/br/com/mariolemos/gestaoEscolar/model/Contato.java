package br.com.mariolemos.gestaoEscolar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONTATO")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;
    @Column(name = "CONTATO")
    private String contato;
    @Column(name = "TIPO_CONTATO")
    private String tipo;
    @ManyToOne
    private Aluno aluno;
    @ManyToOne
    private Responsavel responsavel;
    @ManyToOne
    private Colegio colegio;
}
