package org.serratec.backend.exercicioPaginacaoDTO.repository;

import org.serratec.backend.exercicioPaginacaoDTO.domain.Leitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeitorRepository extends JpaRepository<Leitor, Long>{

	Leitor findByEmail(String email);
}
