package org.serratec.backend.exercicioPaginacaoDTO.controller;

import java.net.URI;
import java.util.List;

import org.serratec.backend.exercicioPaginacaoDTO.dto.AutorDTO;
import org.serratec.backend.exercicioPaginacaoDTO.dto.AutorInserirDTO;
import org.serratec.backend.exercicioPaginacaoDTO.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	AutorService autorService;

	@GetMapping
	public ResponseEntity<List<AutorDTO>> listar() {
		return ResponseEntity.ok(autorService.exibirAutores());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AutorDTO> listarAutor(@PathVariable Long id) {
		AutorDTO autorDTO = autorService.exibirAutor(id);
		if(autorDTO != null) {
			return ResponseEntity.ok(autorDTO);
		}
		return ResponseEntity.notFound().build();
	}


	@PostMapping
	public ResponseEntity<AutorDTO> inserir(@RequestBody AutorInserirDTO autorIns){
		AutorDTO autorDto = new AutorDTO(autorService.inserirAutor(autorIns));

		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(autorDto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(autorDto);
	}

}
