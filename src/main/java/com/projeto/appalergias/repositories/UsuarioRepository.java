package com.projeto.appalergias.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto.appalergias.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Optional<Usuario> findById(Integer id);
}
