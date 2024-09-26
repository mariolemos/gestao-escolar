package br.com.mariolemos.gestaoEscolar.controller;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
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
    @PostMapping
    public ResponseEntity<Aluno> incluir(@RequestBody Aluno aluno){
        aluno = alunoService.incluir(aluno);
        return ResponseEntity.ok().body(aluno);
    }
}
