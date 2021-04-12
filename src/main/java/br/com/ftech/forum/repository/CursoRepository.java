package br.com.ftech.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ftech.forum.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);

}
