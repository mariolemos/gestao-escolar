package br.com.mariolemos.gestaoEscolar.model.dto.request;

import br.com.mariolemos.gestaoEscolar.enumerations.TipoContato;
import br.com.mariolemos.gestaoEscolar.model.Contato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoRequest {

    private Long id;
    private String contato;
    private String tipo;

    public  static Contato of(ContratoRequest contatoRequest){

        Contato contato = new Contato();

        contato.setContato(contatoRequest.getContato());
        contato.setTipo(TipoContato.find(contatoRequest.getTipo()));

        return contato;
    }

    public static List<Contato> of(List<ContratoRequest> contatos) {
        return contatos.stream().map(ContratoRequest::of).collect(Collectors.toList());
    }
}
