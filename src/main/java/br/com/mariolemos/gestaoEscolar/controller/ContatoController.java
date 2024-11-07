package br.com.mariolemos.gestaoEscolar.controller;

import br.com.mariolemos.gestaoEscolar.model.Contato;
import br.com.mariolemos.gestaoEscolar.model.Responsavel;
import br.com.mariolemos.gestaoEscolar.model.dto.response.ContatoResponse;
import br.com.mariolemos.gestaoEscolar.service.ContatoService;
import br.com.mariolemos.gestaoEscolar.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<Contato>> buscar(){
        List<Contato> contatos = contatoService.buscar();
        return ResponseEntity.ok().body(contatos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContatoResponse> buscarPorID(@PathVariable("id") Long id){
        Contato contato = contatoService.buscarPorId(id);
        return ResponseEntity.ok().body(new ContatoResponse(contato));
    }

    @PostMapping
    public ResponseEntity<Contato> incluir(@RequestBody Contato contato) {
        contato = contatoService.incluir(contato);
        return ResponseEntity.ok().body(contato);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizar(@RequestBody Contato contato, @PathVariable("id") Long id){
        Contato contato1 = contatoService.atualizar(contato, id);
        return ResponseEntity.ok().body(contato1);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        contatoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
