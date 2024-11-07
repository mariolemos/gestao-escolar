package br.com.mariolemos.gestaoEscolar.controller;

import br.com.mariolemos.gestaoEscolar.model.Colegio;
import br.com.mariolemos.gestaoEscolar.model.Endereco;
import br.com.mariolemos.gestaoEscolar.service.ColegioService;
import br.com.mariolemos.gestaoEscolar.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> buscar(){
        List<Endereco> colegios = enderecoService.buscar();
        return ResponseEntity.ok().body(colegios);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorID(@PathVariable("id") Long id){
        Endereco endereco = enderecoService.buscarPorId(id);
        return ResponseEntity.ok().body(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizar(@RequestBody Endereco endereco, @PathVariable("id") Long id){
        Endereco endereco1 = enderecoService.atualizar(endereco, id);
        return ResponseEntity.ok().body(endereco1);
    }

    @PostMapping
    public ResponseEntity<Endereco> incluir(@RequestBody Endereco endereco){
        endereco = enderecoService.incluir(endereco);
        return ResponseEntity.ok().body(endereco);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        enderecoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
