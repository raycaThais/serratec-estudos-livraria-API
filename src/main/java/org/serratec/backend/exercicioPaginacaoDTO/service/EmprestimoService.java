package org.serratec.backend.exercicioPaginacaoDTO.service;

import java.util.Optional;

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
	LivroService livroService; // inserir um buscarPorId no livroService

	
	//trocar email por autenticação do leitor, caso seja o próprio leitor que fará os emprestimos
	public Emprestimo inserirEmprestimo(EmprestimoInserirDTO emprestimoIns) {
		Optional<Livro> livroOpt = livroRepository.findById(emprestimoIns.getIdLivro());
		if (livroOpt.isPresent()) {
			Livro livro = livroOpt.get();
			String leitorEmail = emprestimoIns.getEmailLeitor();
			Optional<Leitor> leitorOpt = leitorRepository.findByEmail(leitorEmail);	
			if (leitorOpt.isPresent()) {
				Leitor leitor = leitorOpt.get();
				Emprestimo emprestimo = new Emprestimo(livro, leitor);
				emprestimoRepository.save(emprestimo);
				leitor.getEmprestimos().add(emprestimo);
				return emprestimo;
			}
		} return null;
	}
	

}
