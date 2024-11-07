package br.com.mariolemos.gestaoEscolar.service;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Colegio;
import br.com.mariolemos.gestaoEscolar.model.Endereco;
import br.com.mariolemos.gestaoEscolar.repository.AlunoRepository;
import br.com.mariolemos.gestaoEscolar.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> buscar(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos;
    }
    public Endereco buscarPorId(Long id){
        return enderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
    }

    public Endereco incluir(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizar(Endereco endereco, Long id){
        Endereco endereco1 = buscarPorId(id);
        endereco1.setLogradouro(endereco.getLogradouro());
        endereco1.setNumero(endereco.getNumero());
        endereco1.setComplemento(endereco.getComplemento());
        endereco1.setCep(endereco.getCep());
        endereco1.setBairro(endereco.getBairro());
        endereco1.setCidade(endereco.getCidade());
        endereco1.setEstado(endereco.getEstado());
        return enderecoRepository.save(endereco1);
    }

    public void excluir(Long id){
        enderecoRepository.deleteById(id);
    }

}
