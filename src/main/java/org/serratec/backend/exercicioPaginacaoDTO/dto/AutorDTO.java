package org.serratec.backend.exercicioPaginacaoDTO.dto;

import java.util.List;

import org.serratec.backend.exercicioPaginacaoDTO.domain.Autor;
import org.serratec.backend.exercicioPaginacaoDTO.domain.Livro;

public class AutorDTO {

	private Long id;
	
	private String nome;
	
	private String nacionalidade;
	
	private List<Livro> livros;

	public AutorDTO(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.nacionalidade = autor.getNacionalidade();
		this.livros = autor.getLivros();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
}
