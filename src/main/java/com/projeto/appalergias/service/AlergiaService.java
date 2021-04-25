package com.projeto.appalergias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.appalergias.domain.Alergia;
import com.projeto.appalergias.dto.AlergiaDTO;
import com.projeto.appalergias.repositories.AlergiaRepository;

@Service
public class AlergiaService {

	@Autowired
	private AlergiaRepository alergiaRepository;

//	o metodo de inserção de alergia deverá ficar na classe do usuário
	public Alergia fromDTO(AlergiaDTO alergiaDTO) {
		return new Alergia(alergiaDTO.getId(), alergiaDTO.getNomeAlergia(), alergiaDTO.getDescricao(), alergiaDTO.getUsuario());
	}
	
	public Alergia inserir(Alergia alergia) {
		alergia.setId(null);
		alergiaRepository.save(alergia);
		return alergia;
	}
	
//	public Alergia inserir(Alergia alergia, Integer idUsuario) throws ObjectNotFoundException {
//		alergia.setId(null);
//		Usuario usuario = usuarioService.buscarId(idUsuario);
//		alergia.setUsuario(usuario);
//		alergiaRepository.save(alergia);
//		return alergia;
//	}

}
