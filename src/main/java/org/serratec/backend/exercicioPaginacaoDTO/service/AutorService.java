package org.serratec.backend.exercicioPaginacaoDTO.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.exercicioPaginacaoDTO.domain.Autor;
import org.serratec.backend.exercicioPaginacaoDTO.dto.AutorDTO;
import org.serratec.backend.exercicioPaginacaoDTO.dto.AutorInserirDTO;
import org.serratec.backend.exercicioPaginacaoDTO.exceptions.EmailException;
import org.serratec.backend.exercicioPaginacaoDTO.exceptions.SenhaException;
import org.serratec.backend.exercicioPaginacaoDTO.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AutorService {

	@Autowired
	AutorRepository autorRepository;

	public Autor inserirAutor(AutorInserirDTO autorIns) throws SenhaException, EmailException {
		if (!autorIns.getSenha().equals(autorIns.getConfirmaSenha())){
			throw new SenhaException("As senhas informadas não são iguais. Verifique");
		}	
		if (autorRepository.findByEmail(autorIns.getEmail()) != null) { 
			throw new EmailException("Email já cadastrado!");
		}

		Autor autor = new Autor(autorIns);
		return autorRepository.save(autor);	
	}

	public List<AutorDTO> exibirAutores() {
		List<Autor> listaAutores = autorRepository.findAll();
		List<AutorDTO> listaAutoresDTO = new ArrayList<>();
		for(Autor a : listaAutores) {
			listaAutoresDTO.add(new AutorDTO(a));
		}
		return listaAutoresDTO;

	}

	public AutorDTO exibirAutor(Long id) {
		Optional<Autor> autorOpt = autorRepository.findById(id);
		if (autorOpt.isPresent()) {
			Autor autorAchado = autorOpt.get();
			AutorDTO autorDTO = new AutorDTO(autorAchado);
			return autorDTO;
		} 
		return null;

	}
}
