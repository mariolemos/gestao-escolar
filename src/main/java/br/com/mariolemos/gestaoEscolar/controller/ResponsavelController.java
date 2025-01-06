package br.com.mariolemos.gestaoEscolar.controller;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Responsavel;
import br.com.mariolemos.gestaoEscolar.model.dto.response.ResponsavelResponse;
import br.com.mariolemos.gestaoEscolar.service.AlunoService;
import br.com.mariolemos.gestaoEscolar.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/responsavel")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @GetMapping
    public ResponseEntity<List<ResponsavelResponse>> buscar(){
        List<Responsavel> resposaveis = responsavelService.buscar();
        return ResponseEntity.ok().body(ResponsavelResponse.of(resposaveis));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelResponse> buscarPorID(@PathVariable("id") Long id){
        Responsavel responsavel = responsavelService.buscarPorId(id);
        return ResponseEntity.ok().body(new ResponsavelResponse(responsavel));
    }

    @PostMapping
    public ResponseEntity<Responsavel> incluir(@RequestBody Responsavel responsavel) {
        responsavel = responsavelService.incluir(responsavel);
        return ResponseEntity.ok().body(responsavel);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponsavelResponse> atualizar(@RequestBody Responsavel responsavel, @PathVariable("id") Long id){
        Responsavel responsavel1 = responsavelService.atualizar(responsavel, id);
        return ResponseEntity.ok().body(new ResponsavelResponse(responsavel1));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        responsavelService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
