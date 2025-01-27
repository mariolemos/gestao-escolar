package br.com.mariolemos.gestaoEscolar.model.dto.request;

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
public class ColegioRequest {

    private Long id;
    private String nome;
    private LocalTime horario;
    private List<Contato> contatos = new ArrayList<>();
    private Endereco endereco;

    public static Colegio of(ColegioRequest colegioRequest){

        Colegio colegio = new Colegio();

        colegio.setNome(colegioRequest.getNome());
        colegio.setHorario(colegioRequest.getHorario());

        return colegio;

    }

}
