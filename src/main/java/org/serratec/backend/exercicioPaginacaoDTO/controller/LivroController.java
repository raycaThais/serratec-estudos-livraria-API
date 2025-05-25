package org.serratec.backend.exercicioPaginacaoDTO.controller;

import java.net.URI;

import org.serratec.backend.exercicioPaginacaoDTO.domain.Livro;
import org.serratec.backend.exercicioPaginacaoDTO.dto.LivroDTO;
import org.serratec.backend.exercicioPaginacaoDTO.dto.LivroInserirDTO;
import org.serratec.backend.exercicioPaginacaoDTO.repository.LivroRepository;
import org.serratec.backend.exercicioPaginacaoDTO.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity<Page<Livro>> listarPaginado(
        @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Livro> livros = livroService.buscarPagina(pageable);
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/porNacionalidade")
    public ResponseEntity<Page<Livro>> listarPorNacionalidade(String nacionalidade, Pageable pageable ) {
        Page<Livro> livros = livroService.buscarNacionalidade(nacionalidade, pageable);
        return ResponseEntity.ok(livros);
    }
}
