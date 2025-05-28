package org.serratec.backend.exercicioPaginacaoDTO.repository;

import org.serratec.backend.exercicioPaginacaoDTO.domain.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
