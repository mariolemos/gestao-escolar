package br.com.mariolemos.gestaoEscolar.model.dto.response;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Colegio;
import br.com.mariolemos.gestaoEscolar.model.Contato;
import br.com.mariolemos.gestaoEscolar.model.Responsavel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoResponse {

    private Long id;
    private String contato;
    private String tipo;

    public ContatoResponse(Contato contato){
        this.id = contato.getId();
        this.contato = contato.getContato();
        this.tipo = contato.getTipo().getDescricao();
    }
    public static List<ContatoResponse> of(List<Contato> contatos) {
        return contatos.stream().map(ContatoResponse::new).collect(Collectors.toList());
    }

}
