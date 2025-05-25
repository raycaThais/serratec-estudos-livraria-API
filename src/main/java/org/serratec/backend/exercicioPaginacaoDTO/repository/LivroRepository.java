package org.serratec.backend.exercicioPaginacaoDTO.repository;

import org.serratec.backend.exercicioPaginacaoDTO.domain.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    Page<Livro> findByAutorNacionalidade(String nacionalidade, Pageable pageable);

}
