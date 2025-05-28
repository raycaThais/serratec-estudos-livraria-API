package org.serratec.backend.exercicioPaginacaoDTO.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.text.similarity.LevenshteinDistance;

import org.serratec.backend.exercicioPaginacaoDTO.domain.Livro;
import org.serratec.backend.exercicioPaginacaoDTO.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	LivroRepository livroRepository;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<String> erros = new ArrayList<>();
		for (FieldError err: ex.getBindingResult().getFieldErrors()) {
			erros.add(err.getField() + ": " + err.getDefaultMessage());
		}
		
		ErroResposta erroResposta = new ErroResposta(status.value(), "Foi inserido um valor inválido.", LocalDateTime.now(), erros);
		
		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<String> erros = new ArrayList<>();
		erros.add(ex.getMostSpecificCause().getLocalizedMessage());
		
		ErroResposta erroResposta = new ErroResposta(status.value(), "Erro de leitura da requisição: Verifique a formatação do JSON", LocalDateTime.now(), erros);
		
		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	}
	
	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<Map<String, Object>> handleLivroNaoEncontrado(LivroNaoEncontradoException ex) {
		String livroNaoEncontrado = ex.getLivroNaoEncontrado();
		
		List<String> livros = livroRepository.findAll()
				.stream().map(Livro::getTitulo).collect(Collectors.toList());
		
		 LevenshteinDistance distancia = new LevenshteinDistance();
		 List<String> sugestoes = livros.stream().sorted(Comparator.comparingInt(livro -> distancia.apply(livroNaoEncontrado.toLowerCase(),livro.toLowerCase())))
				 .limit(5).collect(Collectors.toList());
		 
		 Map<String, Object> resposta = new HashMap<>();
		    resposta.put("mensagem", "Livro não encontrado. Você quis dizer:");
		    resposta.put("sugestoes", sugestoes);

		    return ResponseEntity.badRequest().body(resposta);
		
	}

}
