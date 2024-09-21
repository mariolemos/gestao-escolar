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
public class Responsavel extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String parentesco;
    @OneToMany
    private List<Contrato>  contratos = new ArrayList<>();
    @OneToMany
    private List<Aluno> alunos = new ArrayList<>();
}
