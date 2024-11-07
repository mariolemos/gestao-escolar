package br.com.mariolemos.gestaoEscolar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALUNO")
public class Aluno extends Pessoa {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @EqualsAndHashCode.Include
//    @Column(name = "ID")
//    private Long id;
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
    private String convenioMedico;
    @Column(name = "ATIVO")
    private Boolean ativo;
    @ManyToOne
    private Responsavel responsavel;
    @ManyToOne
    private Colegio colegio;
    @OneToMany
    @JoinColumn(name = "ALUNO_ID")
    private List<Contato> contatos = new ArrayList<Contato>();
    @OneToOne(mappedBy = "aluno")
    private Endereco endereco;
}
