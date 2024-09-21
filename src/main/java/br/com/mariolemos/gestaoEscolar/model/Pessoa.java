package br.com.mariolemos.gestaoEscolar.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    public String nome;
    private LocalDate dtNascimento;
    private String cpf;
    private String rg;
    //private Endereco endereco;
    @OneToMany
    private List<Contato> contatos = new ArrayList<Contato>();
}
