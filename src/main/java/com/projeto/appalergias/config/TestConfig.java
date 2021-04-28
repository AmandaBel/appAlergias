package com.projeto.appalergias.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.appalergias.service.DBService;
import com.sun.el.parser.ParseException;

@Configuration
@Profile("teste")
public class TestConfig {

//	UTILIZADO PARA CRIAR DADOS PARA DETERMINADO AMBIENTE, TIPO: TESTE, PRODUCAO E DESENVOLVIMENTO.
	
	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instaciancaoDadosTeste();
		return true;
	}
}
