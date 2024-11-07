package br.com.mariolemos.gestaoEscolar.controller;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Colegio;
import br.com.mariolemos.gestaoEscolar.model.dto.response.ColegioResponse;
import br.com.mariolemos.gestaoEscolar.service.AlunoService;
import br.com.mariolemos.gestaoEscolar.service.ColegioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/colegio")
public class ColegioController {

    @Autowired
    private ColegioService colegioService;

    @GetMapping
    public ResponseEntity<List<Colegio>> buscar(){
        List<Colegio> colegios = colegioService.buscar();
        return ResponseEntity.ok().body(colegios);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ColegioResponse> buscarPorID(@PathVariable("id") Long id){
        Colegio colegio = colegioService.buscarPorId(id);
        return ResponseEntity.ok().body(new ColegioResponse(colegio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colegio> atualizar(@RequestBody Colegio colegio, @PathVariable("id") Long id){
        Colegio colegio1 = colegioService.atualizar(colegio, id);
        return ResponseEntity.ok().body(colegio1);
    }

    @PostMapping
    public ResponseEntity<Colegio> incluir(@RequestBody Colegio colegio){
        colegio = colegioService.incluir(colegio);
        return ResponseEntity.ok().body(colegio);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        colegioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
