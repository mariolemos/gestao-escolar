package br.com.mariolemos.gestaoEscolar.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import javax.naming.ldap.PagedResultsControl;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "COLEGIO_ID")
    private List<Aluno> alunos = new ArrayList<Aluno>();
    //private List<Contato> conttos = new ArrayList<Contato>();

}
