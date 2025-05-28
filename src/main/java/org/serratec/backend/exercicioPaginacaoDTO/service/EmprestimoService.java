package org.serratec.backend.exercicioPaginacaoDTO.service;

import org.serratec.backend.exercicioPaginacaoDTO.domain.Emprestimo;
import org.serratec.backend.exercicioPaginacaoDTO.domain.Leitor;
import org.serratec.backend.exercicioPaginacaoDTO.domain.Livro;
import org.serratec.backend.exercicioPaginacaoDTO.dto.EmprestimoInserirDTO;
import org.serratec.backend.exercicioPaginacaoDTO.repository.EmprestimoRepository;
import org.serratec.backend.exercicioPaginacaoDTO.repository.LeitorRepository;
import org.serratec.backend.exercicioPaginacaoDTO.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {
	
	@Autowired
	EmprestimoRepository emprestimoRepository;
	
	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	LeitorRepository leitorRepository;
	
	@Autowired
	LivroService livroService;
	
	public Emprestimo inserirEmprestimo(EmprestimoInserirDTO emprestimoIns) { // fazer verificações de nulo
	String titulo =	emprestimoIns.getTituloLivro();
	Livro livro = livroService.buscarPorTitulo(titulo);
	String leitorEmail = emprestimoIns.getEmailLeitor();
	Leitor leitor = leitorRepository.findByEmail(leitorEmail); //por email ou por autenticação do cliente logado?
	Emprestimo emprestimo = new Emprestimo();
	emprestimo.setLivro(livro);
	emprestimo.setLeitor(leitor);

	emprestimoRepository.save(emprestimo);
	return emprestimo;
		
	}

}
