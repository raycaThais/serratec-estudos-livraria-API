package org.serratec.backend.exercicioPaginacaoDTO.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.serratec.backend.exercicioPaginacaoDTO.domain.Livro;

public class LivroDTO {

	private Long id;
	
	private String titulo;
	
	private LocalDate dataPublicacao;
	
	private String genero;
	
	private LocalDateTime dataCadastro;
	
	private String nomeAutor;
	
	public LivroDTO(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.dataPublicacao = livro.getDataPublicacao();
		this.genero = livro.getGenero();
		this.dataCadastro = livro.getDataCadastro();
		this.nomeAutor = livro.getAutor().getNome();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
		
	
}
