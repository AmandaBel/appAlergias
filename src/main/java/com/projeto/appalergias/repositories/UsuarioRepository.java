package com.projeto.appalergias.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.appalergias.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Transactional(readOnly = true)
	Optional<Usuario> findById(Integer id);

	@Transactional(readOnly = true)
	Usuario findByRg(Integer rg);
//	Optional<Usuario> findByRg(Integer rg);
}
