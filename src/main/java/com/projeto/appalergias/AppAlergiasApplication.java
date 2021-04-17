package com.projeto.appalergias;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.appalergias.domain.Alergia;
import com.projeto.appalergias.domain.Usuario;
import com.projeto.appalergias.repositories.AlergiaRepository;
import com.projeto.appalergias.repositories.UsuarioRepository;

@SpringBootApplication
public class AppAlergiasApplication implements CommandLineRunner {
	
	@Autowired
	AlergiaRepository alergiaRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppAlergiasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Usuario usuario = new Usuario(null, "fulano", new Date(), "99999999", 12345, 1234, "teste@teste", "123");
		Alergia alergia = new Alergia(null, "alergiaXpto", "adadasdsadas", usuario);
		Alergia alergia2 = new Alergia(null, "alergia2Xpto2", "teste", usuario);
		
		usuario.getAlergias().addAll(Arrays.asList(alergia, alergia2));
		
		usuarioRepository.saveAll(Arrays.asList(usuario));
		alergiaRepository.saveAll(Arrays.asList(alergia, alergia2));
		
		
	}
}
