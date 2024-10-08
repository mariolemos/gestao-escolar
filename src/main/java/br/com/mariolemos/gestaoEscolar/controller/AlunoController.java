package br.com.mariolemos.gestaoEscolar.controller;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Colegio;
import br.com.mariolemos.gestaoEscolar.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> buscar(){
        List<Aluno> alunos = alunoService.buscar();
        return ResponseEntity.ok().body(alunos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorID(@PathVariable("id") Long id){
        Aluno aluno = alunoService.buscarPorId(id);
        return ResponseEntity.ok().body(aluno);
    }
    @GetMapping("/colegio/{id}")
    public ResponseEntity<List<Aluno>> buscarPorColegio(@PathVariable("id") Long colegioId){
        List<Aluno> alunos = alunoService.buscarAlunoPorColegio(colegioId);
        return ResponseEntity.ok().body(alunos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@RequestBody Aluno aluno, @PathVariable("id") Long id){
        Aluno aluno1 = alunoService.atualizar(aluno, id);
        return ResponseEntity.ok().body(aluno1);
    }

    @PostMapping
    public ResponseEntity<Aluno> incluir(@RequestBody Aluno aluno){
        aluno = alunoService.incluir(aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        alunoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
