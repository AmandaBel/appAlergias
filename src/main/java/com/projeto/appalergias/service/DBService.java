package com.projeto.appalergias.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto.appalergias.domain.Alergia;
import com.projeto.appalergias.domain.Usuario;
import com.projeto.appalergias.repositories.AlergiaRepository;
import com.projeto.appalergias.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AlergiaRepository alergiaRepository;

	public void instaciancaoDadosTeste() {
		Usuario usuario = new Usuario(null, "fulano", new Date(), "99999999", 12345, 1234, "teste@teste", passwordEncoder.encode("123"));
		Alergia alergia = new Alergia(null, "alergiaXpto", "adadasdsadas", usuario);
		Alergia alergia2 = new Alergia(null, "alergia2Xpto2", "teste", usuario);

		usuario.getAlergias().addAll(Arrays.asList(alergia, alergia2));

		usuarioRepository.saveAll(Arrays.asList(usuario));
		alergiaRepository.saveAll(Arrays.asList(alergia, alergia2));
	}

}
