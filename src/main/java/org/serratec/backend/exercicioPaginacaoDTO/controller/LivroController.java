package org.serratec.backend.exercicioPaginacaoDTO.controller;

import java.net.URI;

import org.serratec.backend.exercicioPaginacaoDTO.dto.LivroDTO;
import org.serratec.backend.exercicioPaginacaoDTO.dto.LivroInserirDTO;
import org.serratec.backend.exercicioPaginacaoDTO.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@PostMapping
	public ResponseEntity<LivroDTO> inserir(@RequestBody LivroInserirDTO livroIns){
		LivroDTO livroDTO = new LivroDTO(livroService.inserirLivro(livroIns));
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(livroDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(livroDTO);
	}

}
