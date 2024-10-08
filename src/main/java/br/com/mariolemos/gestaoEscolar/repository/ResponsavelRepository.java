package br.com.mariolemos.gestaoEscolar.repository;

import br.com.mariolemos.gestaoEscolar.model.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

}
