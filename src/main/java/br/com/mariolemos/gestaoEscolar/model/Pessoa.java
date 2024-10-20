package br.com.mariolemos.gestaoEscolar.model;

import jakarta.persistence.*;
import lombok.*;

import javax.naming.Name;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dtNascimento;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "RG")
    private String rg;
    //private Endereco endereco;
    @OneToMany
    @Column(name = "PESSOA_ID")
    private List<Contato> contatos = new ArrayList<Contato>();
}
