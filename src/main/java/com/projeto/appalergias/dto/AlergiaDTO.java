package com.projeto.appalergias.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.projeto.appalergias.domain.Alergia;
import com.projeto.appalergias.domain.Usuario;

public class AlergiaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String nomeAlergia;
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String descricao;
	
	private Usuario usuario;

	public AlergiaDTO() {

	}

	public AlergiaDTO(Alergia alergia) {
		id = alergia.getId();
		nomeAlergia = alergia.getNomeAlergia();
		descricao = alergia.getDescricao();
		usuario = alergia.getUsuario();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeAlergia() {
		return nomeAlergia;
	}

	public void setNomeAlergia(String nomeAlergia) {
		this.nomeAlergia = nomeAlergia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
