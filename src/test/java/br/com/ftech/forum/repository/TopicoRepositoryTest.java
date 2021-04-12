package br.com.ftech.forum.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.ftech.forum.model.Curso;
import br.com.ftech.forum.model.Topico;
import br.com.ftech.forum.repository.CursoRepository;
import br.com.ftech.forum.repository.TopicoRepository;

@DataJpaTest
@TestInstance(Lifecycle.PER_CLASS)
public class TopicoRepositoryTest {

	@Autowired
	TopicoRepository repository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	Topico topico;

	@BeforeAll
	void init() {
		Curso curso = new Curso();
		curso.setNome("java");
		cursoRepository.save(curso);
		topico = new Topico("teste", "teste topico", curso);
		repository.save(topico);
	}

	@Test
	public void testSave() {
		Assertions.assertNotNull(topico.getId());
	}

	@Test
	public void testFindByCursoNome() {
		Page<Topico> pages = repository.findByCursoNome("java", PageRequest.of(0, 2));
		Assertions.assertNotNull(pages);
	}

}
