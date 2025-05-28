package org.serratec.backend.exercicioPaginacaoDTO.dto;

import java.util.List;

import org.serratec.backend.exercicioPaginacaoDTO.domain.Emprestimo;
import org.serratec.backend.exercicioPaginacaoDTO.domain.Leitor;

public class LeitorDTO {

	private Long id;
	
	private String nome;
	
	private List<Emprestimo> emprestimos;
	
	public LeitorDTO(Leitor leitor) {
		this.id = leitor.getId();
		this.nome = leitor.getNome();
		this.emprestimos = leitor.getEmprestimos();
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

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	
	
}
