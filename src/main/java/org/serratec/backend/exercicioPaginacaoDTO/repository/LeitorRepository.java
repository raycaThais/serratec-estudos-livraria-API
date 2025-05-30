package org.serratec.backend.exercicioPaginacaoDTO.repository;

import java.util.Optional;

import org.serratec.backend.exercicioPaginacaoDTO.domain.Leitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeitorRepository extends JpaRepository<Leitor, Long>{

	Optional<Leitor> findByEmail(String email);
}
