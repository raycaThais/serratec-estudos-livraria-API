package org.serratec.backend.exercicioPaginacaoDTO.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @OneToOne
    @JoinColumn (name = "id_livro")
	private Livro livro;
	
    @JsonBackReference
	@ManyToOne
	@JoinColumn (name = "id_leitor")
	private Leitor leitor;
	
	private LocalDate dataEmprestimo;
	
	private LocalDate dataDevolucao;
	
	public Emprestimo () {}
	
	public Emprestimo(Livro livro, Leitor leitor) {
		this.livro = livro;
		this.leitor = leitor;
	}

	@PrePersist
	public void setarDataEmprestimo() {
		this.dataEmprestimo = LocalDate.now();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Leitor getLeitor() {
		return leitor;
	}

	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
}
