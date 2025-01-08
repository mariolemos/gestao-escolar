package br.com.mariolemos.gestaoEscolar.controller;

import br.com.mariolemos.gestaoEscolar.model.Contrato;
import br.com.mariolemos.gestaoEscolar.model.dto.response.ContratoResponse;
import br.com.mariolemos.gestaoEscolar.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contrato")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public ResponseEntity<List<ContratoResponse>> buscar(){
        List<Contrato> contratos = contratoService.buscar();
        return ResponseEntity.ok().body(ContratoResponse.of(contratos));
    }
    @PostMapping
    public ResponseEntity<Contrato> incluir(@RequestBody Contrato contrato){
        contrato = contratoService.incluir(contrato);
        return ResponseEntity.ok().body(contrato);
    }
}
