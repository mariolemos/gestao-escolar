package br.com.mariolemos.gestaoEscolar.model.dto.request;

import br.com.mariolemos.gestaoEscolar.enumerations.TipoContato;
import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Colegio;
import br.com.mariolemos.gestaoEscolar.model.Contato;
import br.com.mariolemos.gestaoEscolar.model.Responsavel;
import br.com.mariolemos.gestaoEscolar.model.dto.response.AlunoResponse;
import br.com.mariolemos.gestaoEscolar.model.dto.response.ContatoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoRequest {

    private Long id;
    private String contato;
    private String tipo;

    public  static Contato of(ContatoRequest contatoRequest){

        Contato contato = new Contato();

        contato.setContato(contatoRequest.getContato());
        contato.setTipo(TipoContato.find(contatoRequest.getTipo()));
        contato.setId(contatoRequest.getId());

        return contato;
    }

    public static List<Contato> of(List<ContatoRequest> contatos) {
        return contatos.stream().map(ContatoRequest::of).collect(Collectors.toList());
    }
}
