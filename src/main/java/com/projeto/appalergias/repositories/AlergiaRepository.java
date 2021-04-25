package com.projeto.appalergias.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.appalergias.domain.Alergia;

@Repository
public interface AlergiaRepository extends JpaRepository<Alergia, Integer>{

	Optional<Alergia> findById(Integer id);
}
