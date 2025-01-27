package br.com.mariolemos.gestaoEscolar.service;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Colegio;
import br.com.mariolemos.gestaoEscolar.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ContatoService contatoService;

    public List<Aluno> buscar(){
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos;
    }
    public Aluno buscarPorId(Long id){
        return alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
    }
    public List<Aluno> buscarAlunoPorColegio(Long colegioId){
        Colegio colegio = new Colegio();
        colegio.setId(colegioId);
        return alunoRepository.findByColegio(colegio);
    }

    public Aluno incluir(Aluno aluno){
        return alunoRepository.save(aluno);
    }
    @Transactional
    public Aluno atualizar(Aluno aluno, Long id){
        Aluno aluno1 = buscarPorId(id);
        aluno1.setNomeDoPai(aluno.getNomeDoPai());
        aluno1.setColegio(aluno.getColegio());
        aluno1.setNome(aluno.getNome());
        aluno1.setNomeDaMae(aluno.getNomeDaMae());
        aluno1.setConvenioMedico(aluno.getConvenioMedico());
        aluno1.setResponsavel(aluno.getResponsavel());
        aluno1.setDtNascimento(aluno.getDtNascimento());
        aluno1.setSerie(aluno.getSerie());
        aluno1.setTurma(aluno.getTurma());
        aluno1.setTurno(aluno.getTurno());
        aluno1.setAtivo(aluno.getAtivo());
        aluno1.setColegio(aluno.getColegio());
        contatoService.excluirContatosAluno(id);
        aluno1.setContatos(aluno.getContatos());
        return alunoRepository.save(aluno1);
    }

    public void excluir(Long id){
        alunoRepository.deleteById(id);
    }
    

}
