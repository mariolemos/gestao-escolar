package br.com.mariolemos.gestaoEscolar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "PARENTESCO")
    private String parentesco;
    @OneToMany
    @JoinColumn(name = "RESPONSAVEL_ID")
    private List<Contrato>  contratos = new ArrayList<>();
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "RESPONSAVEL_ID")
    private List<Aluno> alunos = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "RESPONSAVEL_ID")
    private List<Contato> contatos = new ArrayList<Contato>();
    @OneToOne(mappedBy = "responsavel")
    private Endereco endereco;
}
