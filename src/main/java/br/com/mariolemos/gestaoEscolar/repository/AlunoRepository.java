package br.com.mariolemos.gestaoEscolar.repository;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
