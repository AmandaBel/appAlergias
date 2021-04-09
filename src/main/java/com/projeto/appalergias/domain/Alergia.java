package com.projeto.appalergias.domain;

import java.io.Serializable;

public class Alergia implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nomeAlergia;
	private String descrição;
	private Usuario usuario;

	public Alergia() {

	}

	public Alergia(Integer id, String nomeAlergia, String descrição, Usuario usuario) {
		super();
		this.id = id;
		this.nomeAlergia = nomeAlergia;
		this.descrição = descrição;
		this.usuario = usuario;
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

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrição == null) ? 0 : descrição.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeAlergia == null) ? 0 : nomeAlergia.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alergia other = (Alergia) obj;
		if (descrição == null) {
			if (other.descrição != null)
				return false;
		} else if (!descrição.equals(other.descrição))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeAlergia == null) {
			if (other.nomeAlergia != null)
				return false;
		} else if (!nomeAlergia.equals(other.nomeAlergia))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
