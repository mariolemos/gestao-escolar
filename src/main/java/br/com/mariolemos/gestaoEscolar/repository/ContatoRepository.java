package br.com.mariolemos.gestaoEscolar.repository;

import br.com.mariolemos.gestaoEscolar.model.Aluno;
import br.com.mariolemos.gestaoEscolar.model.Contato;
import br.com.mariolemos.gestaoEscolar.model.Responsavel;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    @Modifying
    @Transactional
    @Query("delete from Contato c where c.aluno.id = :alunoId")
    void deleteByAlunoId(@PathParam("alunoId") Long alunoId);

    @Modifying
    @Transactional
    @Query("delete from Contato r where r.responsavel.id = :responsavelId")
    void deleteByResponsavelId(@PathParam("responsavelId") Long responsavelId);

    @Modifying
    @Transactional
    @Query("delete from Contato c where c.colegio.id = :colegioId")
    void deleteByColegioId(@PathParam("colegioId") Long colegioId);

}
