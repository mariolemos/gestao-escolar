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
@Table(name = "ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;
    @Column(name = "LOGRADOURO")
    private String logradouro;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "ESTADO")
    private String estado;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "ALUNO_ID")
    private Aluno aluno;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "RESPONSAVEL_ID")
    private Responsavel responsavel;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "COLEGIO_ID")
    private Colegio colegio;

}
