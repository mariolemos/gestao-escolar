package br.com.mariolemos.gestaoEscolar.service;

import br.com.mariolemos.gestaoEscolar.model.Contato;
import br.com.mariolemos.gestaoEscolar.model.Responsavel;
import br.com.mariolemos.gestaoEscolar.repository.ContatoRepository;
import br.com.mariolemos.gestaoEscolar.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public List<Contato> buscar(){
        List<Contato> contatos = contatoRepository.findAll();
        return contatos;
    }
    public Contato buscarPorId(Long id){
        return contatoRepository.findById(id).orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
    }

    public Contato incluir(Contato contato){
        return contatoRepository.save(contato);
    }
    public Contato atualizar(Contato contato, Long id){
        Contato contato1 = buscarPorId(id);
        contato1.setTipo(contato.getTipo());
        contato1.setContato(contato.getContato());
        return contatoRepository.save(contato);
    }

    public void excluir(Long id){
        contatoRepository.deleteById(id);
    }


}
