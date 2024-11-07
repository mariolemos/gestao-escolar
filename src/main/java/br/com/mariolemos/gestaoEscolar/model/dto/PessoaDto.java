package br.com.mariolemos.gestaoEscolar.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {
    private Long id;
    private String nome;
    private LocalDate dtNascimento;
    private String cpf;
    private String rg;

}
