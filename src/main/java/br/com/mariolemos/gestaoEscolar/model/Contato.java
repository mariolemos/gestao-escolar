package br.com.mariolemos.gestaoEscolar.model;

import br.com.mariolemos.gestaoEscolar.enumerations.TipoContato;
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
    @Enumerated(EnumType.STRING)
    private TipoContato tipo;
    @ManyToOne
    private Aluno aluno;
    @ManyToOne
    private Responsavel responsavel;
    @JsonIgnore
    @ManyToOne
    private Colegio colegio;
}
