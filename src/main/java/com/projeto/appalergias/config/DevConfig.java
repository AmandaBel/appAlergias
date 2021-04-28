package com.projeto.appalergias.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.appalergias.service.DBService;
import com.sun.el.parser.ParseException;

@Configuration
@Profile("dev")
public class DevConfig {

//	UTILIZADO PARA CRIAR DADOS PARA DETERMINADO AMBIENTE, TIPO: TESTE, PRODUCAO E DESENVOLVIMENTO.

	@Autowired
	private DBService dbService;
	
	
//	PEGA O DADO DA VARIAVEL DO ARQUIVO PROPERTIES
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instantiateDatabase() throws ParseException {

		if (!"create".equals(strategy)) {
			return false;
		}

		dbService.instaciancaoDadosTeste();
		return true;
	}
}
