package com.projeto.appalergias.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.appalergias.domain.Alergia;
import com.projeto.appalergias.domain.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

//	@NotEmpty(message = "Preenchimento Obrigatório")
	private String nome;
//	@NotEmpty(message = "Preenchimento Obrigatório")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date datanascimento;
//	@NotEmpty(message = "Preenchimento Obrigatório")
	private String telefone;
//	@NotEmpty(message = "Preenchimento Obrigatório")
	private Integer cartaoSus;
//	@NotEmpty(message = "Preenchimento Obrigatório")
	private Integer rg;
//	@NotEmpty(message = "Preenchimento Obrigatório")
	private String email;
//	@NotEmpty(message = "Preenchimento Obrigatório")
	private String senha;
	private List<Alergia> alergias;

	public UsuarioDTO() {

	}

	public UsuarioDTO(Usuario usuario) {
		id = usuario.getId();
		nome = usuario.getNome();
		datanascimento = usuario.getDatanascimento();
		telefone = usuario.getTelefone();
		cartaoSus = usuario.getCartaoSus();
		rg = usuario.getRg();
		email = usuario.getEmail();
		senha = usuario.getSenha();
		alergias = usuario.getAlergias();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getCartaoSus() {
		return cartaoSus;
	}

	public void setCartaoSus(Integer cartaoSus) {
		this.cartaoSus = cartaoSus;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Alergia> getAlergias() {
		return alergias;
	}

	public void setAlergias(List<Alergia> alergias) {
		this.alergias = alergias;
	}

}
