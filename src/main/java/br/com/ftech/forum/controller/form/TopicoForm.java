package br.com.ftech.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ftech.forum.model.Curso;
import br.com.ftech.forum.model.Topico;
import br.com.ftech.forum.repository.CursoRepository;

public class TopicoForm {

	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String mensagem;
	
	@NotNull @NotEmpty
	private String nomeCurso;
	

	
	public TopicoForm(@NotNull @NotEmpty @Length(min = 5) String titulo,
			@NotNull @NotEmpty @Length(min = 10) String mensagem, @NotNull @NotEmpty String nomeCurso) {
		super();
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.nomeCurso = nomeCurso;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}



	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}

}
