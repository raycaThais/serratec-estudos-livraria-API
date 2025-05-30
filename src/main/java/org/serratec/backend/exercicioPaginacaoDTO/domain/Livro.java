package org.serratec.backend.exercicioPaginacaoDTO.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.serratec.backend.exercicioPaginacaoDTO.dto.LivroInserirDTO;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Preencha o titulo.")
	@Size(max = 150, message = "Número de caracteres máximo de {max} para titulo.")
	@Column(length = 150)
	private String titulo;
	
	@NotNull(message = "Data de Publicação não pode ser nula.")
	private LocalDate dataPublicacao;
	
	@NotBlank(message = "Preencha o gênero.")
	@Size(max = 50, message = "Número de caracteres máximo de {max} para gênero.")
	@Column(length = 50)
	private String genero;
	
	private LocalDateTime dataCadastro;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_autor")
	private Autor autor;

	public Livro () {}
	
	public Livro(LivroInserirDTO livroIns) {
		this.titulo = livroIns.getTitulo();
		this.dataPublicacao = livroIns.getDataPublicacao();
		this.genero = livroIns.getGenero();
		this.dataCadastro = LocalDateTime.now();
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

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
	
}
