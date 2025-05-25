package org.serratec.backend.exercicioPaginacaoDTO.domain;

import java.util.List;

import org.serratec.backend.exercicioPaginacaoDTO.dto.AutorInserirDTO;
import org.serratec.backend.exercicioPaginacaoDTO.util.NomeAutorConversor;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Convert(converter = NomeAutorConversor.class)
	private String nome;
	
	private String email;
	
	private String senha;
	
	private String nacionalidade;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "autor")
	private List<Livro> livros;
	
	public Autor() {}

	public Autor(AutorInserirDTO autorInsDTO) {
		this.nome = autorInsDTO.getNome();
		this.email = autorInsDTO.getEmail();
		this.senha = autorInsDTO.getSenha();
		this.nacionalidade = autorInsDTO.getNacionalidade();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
