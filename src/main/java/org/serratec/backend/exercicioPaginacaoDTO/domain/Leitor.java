package org.serratec.backend.exercicioPaginacaoDTO.domain;

import java.util.List;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Leitor {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Preencha o nome")
	@Size(max=150, message = "Número de caracteres máximo de {max} para nome.")
	@Column(length= 150)
	private String nome;
	
	@Email(message= "E-mail inválido.")
	private String email;
	
	@NotBlank(message ="Preencha a senha")
	@Size(min=6,max=50, message= "Senha deve conter entre {min} e {max} caracteres.")
	@Column(length=50)
	private String senha;
	
	@OneToMany(mappedBy = "leitor")
	@Where(clause = "data_devolucao IS NULL")
	private List<Emprestimo> emprestimos;

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

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	
}
