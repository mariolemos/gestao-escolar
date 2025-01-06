package br.com.mariolemos.gestaoEscolar.controller;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Colegio;
import br.com.mariolemos.gestaoEscolar.model.dto.request.AlunoRequest;
import br.com.mariolemos.gestaoEscolar.model.dto.response.AlunoResponse;
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
    public ResponseEntity<List<AlunoResponse>> buscar(){
        List<Aluno> alunos = alunoService.buscar();
        return ResponseEntity.ok().body(AlunoResponse.of(alunos));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> buscarPorID(@PathVariable("id") Long id){
        Aluno aluno = alunoService.buscarPorId(id);
        return ResponseEntity.ok().body(new AlunoResponse(aluno));
    }
    @GetMapping("/colegio/{id}")
    public ResponseEntity<List<AlunoResponse>> buscarPorColegio(@PathVariable("id") Long colegioId){
        List<Aluno> alunos = alunoService.buscarAlunoPorColegio(colegioId);
        return ResponseEntity.ok().body(AlunoResponse.of(alunos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponse> atualizar(@RequestBody AlunoRequest alunoRequest, @PathVariable("id") Long id){
        Aluno aluno = AlunoRequest.of(alunoRequest);
        aluno = alunoService.atualizar(aluno, id);
        return ResponseEntity.ok().body(new AlunoResponse(aluno));
    }

    @PostMapping
    public ResponseEntity<AlunoResponse> incluir(@RequestBody AlunoRequest alunoRequest){
       Aluno aluno = alunoService.incluir(AlunoRequest.of(alunoRequest));
        return ResponseEntity.ok().body(new AlunoResponse(aluno));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        alunoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
