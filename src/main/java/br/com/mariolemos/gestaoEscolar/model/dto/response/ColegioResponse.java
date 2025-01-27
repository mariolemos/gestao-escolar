package br.com.mariolemos.gestaoEscolar.model.dto.response;

;
import br.com.mariolemos.gestaoEscolar.model.Colegio;

import br.com.mariolemos.gestaoEscolar.model.Contato;
import br.com.mariolemos.gestaoEscolar.model.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColegioResponse {

    private Long id;
    private String nome;
    private LocalTime horario;
    private String aluno;
    private List<Contato> contatos = new ArrayList<>();
    private Endereco endereco;

    public ColegioResponse(Colegio colegio){
        this.id = colegio.getId();
        this.nome = colegio.getNome();
        this.horario = colegio.getHorario();
        this.horario = colegio.getHorario();
        this.contatos = colegio.getContatos();
        this.endereco = colegio.getEndereco();

    }
}
