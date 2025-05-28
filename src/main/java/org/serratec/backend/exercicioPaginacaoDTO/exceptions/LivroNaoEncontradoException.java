package org.serratec.backend.exercicioPaginacaoDTO.exceptions;

public class LivroNaoEncontradoException extends RuntimeException{

	private String livroNaoEncontrado;
	
	public LivroNaoEncontradoException (String livroNaoEncontrado) {
		super("Livro não encontrado: " + livroNaoEncontrado);
		this.livroNaoEncontrado = livroNaoEncontrado;
	}

	public String getLivroNaoEncontrado() {
		return livroNaoEncontrado;
	}
	
}
