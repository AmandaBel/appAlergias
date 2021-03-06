package com.projeto.appalergias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto.appalergias.domain.Usuario;
import com.projeto.appalergias.dto.UsuarioDTO;
import com.projeto.appalergias.repositories.UsuarioRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UsuarioRepository usuarioRepository;

//	BUSCA DE USUARIO POR ID
	public Usuario buscarId(Integer id) throws ObjectNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " , Tipo: " + Usuario.class.getName()));
	}

////	BUSCA DE USUARIO POR RG
//	public Usuario buscarRg(Integer rg) {
//		Optional<Usuario> usuario = usuarioRepository.findByRg(rg);
////		return usuario.orElseThrow(() -> new ObjectNotFoundException(
////				"Objeto não encontrado! Rg " + rg + " , Tipo: " + Usuario.class.getName()));
//		return usuario.get();
//	}

//	BUSCA DE USUARIO POR RG
	public Usuario buscarRg(Integer rg) {
		Usuario usuario = usuarioRepository.findByRg(rg);
		return usuario;
	}

//	EXIBIR TODOS OS USUARIOS
	public List<Usuario> buscarTodos() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios;
	}

//	INSERIR USUARIO
	public Usuario insert(Usuario usuario) {
		usuario.setId(null);
		usuarioRepository.save(usuario);
		return usuario;
	}

	public Usuario update(Usuario usuario) throws ObjectNotFoundException {
		Usuario novoUsuario = buscarId(usuario.getId());
		updateData(novoUsuario,usuario);
		return usuarioRepository.save(novoUsuario);
	}

	public Usuario fromDTO(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.getId(), usuarioDTO.getNome(), usuarioDTO.getDatanascimento(),
				usuarioDTO.getTelefone(), usuarioDTO.getCartaoSus(), usuarioDTO.getRg(), usuarioDTO.getEmail(),
				passwordEncoder.encode(usuarioDTO.getSenha()), usuarioDTO.getAlergias());
	}

	private void updateData(Usuario newUsuario, Usuario usuario) {
		newUsuario.setNome(usuario.getNome());
		newUsuario.setRg(usuario.getRg());
	}
	
	
	public void delete(Integer id) throws ObjectNotFoundException {
		Usuario usuario = buscarId(id);
		usuarioRepository.delete(usuario);
	}

//	EXIBIR RESULTADOS EM PAGINAS
	public Page<Usuario> paginacao(Integer pagina, Integer linha) {
		PageRequest pageRequest = PageRequest.of(pagina, linha);
		return usuarioRepository.findAll(pageRequest);
	}

}
