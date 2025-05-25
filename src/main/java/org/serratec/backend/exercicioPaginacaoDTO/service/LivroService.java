package org.serratec.backend.exercicioPaginacaoDTO.service;

import org.serratec.backend.exercicioPaginacaoDTO.domain.Livro;
import org.serratec.backend.exercicioPaginacaoDTO.dto.LivroInserirDTO;
import org.serratec.backend.exercicioPaginacaoDTO.exceptions.AutorException;
import org.serratec.backend.exercicioPaginacaoDTO.repository.AutorRepository;
import org.serratec.backend.exercicioPaginacaoDTO.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	AutorRepository autorRepository;
	
	public Livro inserirLivro(LivroInserirDTO livroIns) throws AutorException {
		String nomeAutor = livroIns.getNomeAutor().toUpperCase();
		if (autorRepository.findByNome(nomeAutor) == null) {
			throw new AutorException("Autor não cadastrado.");
		}		
		Livro livro = new Livro(livroIns);
		livro.setAutor(autorRepository.findByNome(nomeAutor));
		livroRepository.save(livro);
		
		autorRepository.findByNome(nomeAutor).getLivros().add(livro);
		return livro;
	}
}
