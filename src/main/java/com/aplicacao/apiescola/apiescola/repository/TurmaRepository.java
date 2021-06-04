package com.aplicacao.apiescola.apiescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplicacao.apiescola.apiescola.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
	
	Turma findById(long idTurma);

}
