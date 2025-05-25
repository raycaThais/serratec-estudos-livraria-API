package org.serratec.backend.exercicioPaginacaoDTO.repository;

import org.serratec.backend.exercicioPaginacaoDTO.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{
	
	Autor findByEmail(String email);
	
	Autor findByNome(String nome);
}
