package br.com.mariolemos.gestaoEscolar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COLEGIO")
public class Colegio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "HORARIO")
    private Timestamp horario;
    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "COLEGIO_ID")
    private List<Aluno> alunos = new ArrayList<Aluno>();
    @OneToMany
    @JoinColumn(name = "COLEGIO_ID")
    private List<Contato> contatos = new ArrayList<Contato>();
    @OneToOne(mappedBy = "colegio")
    private Endereco endereco;

}
