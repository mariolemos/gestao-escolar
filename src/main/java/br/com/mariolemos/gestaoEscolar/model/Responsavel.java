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
@Table(name = "RESPONSAVEL")
public class Responsavel extends Pessoa {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @EqualsAndHashCode.Include
//    @Column(name = "ID")
//    private Long id;
//    @Column(name = "NOME")
//    private String nome;
    @Column(name = "PARENTESCO")
    private String parentesco;
    @OneToMany
    @JoinColumn(name = "RESPONSAVEL_ID")
    private List<Contrato>  contratos = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "RESPONSAVEL_ID")
    private List<Aluno> alunos = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "RESPONSAVEL_ID")
    private List<Contato> contatos = new ArrayList<Contato>();
    @ManyToOne
    private Endereco endereco;
}
