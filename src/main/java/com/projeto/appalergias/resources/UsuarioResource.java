package com.projeto.appalergias.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.appalergias.domain.Alergia;
import com.projeto.appalergias.domain.Usuario;
import com.projeto.appalergias.dto.UsuarioDTO;
import com.projeto.appalergias.service.AlergiaService;
import com.projeto.appalergias.service.UsuarioService;
import com.projeto.appalergias.service.exception.UsuarioDuplicadoException;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioservice;

	@Autowired
	private AlergiaService alergiaservice;

	@RequestMapping(value = "id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> findId(@PathVariable Integer id) throws ObjectNotFoundException {
		Usuario usuario = usuarioservice.buscarId(id);
		return ResponseEntity.ok().body(usuario);
	}

	@RequestMapping(value = "rg/{rg}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> findRg(@PathVariable Integer rg) {
		Usuario usuario = usuarioservice.buscarRg(rg);
		return ResponseEntity.ok().body(usuario);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> findALL() {
		List<Usuario> usuarios = usuarioservice.buscarTodos(); 
		return usuarios;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioservice.fromDTO(usuarioDTO);

		if ((usuarioservice.buscarRg(usuario.getRg())) != null) {
			throw new UsuarioDuplicadoException("Já existe usuário cadastrado para o rg: " + usuario.getRg());

		}

		usuario = usuarioservice.insert(usuario);
		System.out.println("TAMANHO:" + usuario.getAlergias().size());
		if (!usuario.getAlergias().isEmpty()) {
			System.out.println("**********ENTROU**********");
			for (int i = 0; i < usuario.getAlergias().size(); i++) {
				Alergia alergia = new Alergia();
				alergia.setUsuario(usuario);
				alergia.setNomeAlergia(usuario.getAlergias().get(i).getNomeAlergia());
				alergia.setDescricao(usuario.getAlergias().get(i).getDescricao());
				alergiaservice.inserir(alergia);
			}

		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioDTO usuarioDTO, @PathVariable Integer id) throws ObjectNotFoundException{
		Usuario usuario = usuarioservice.fromDTO(usuarioDTO);
		usuario.setId(id);
		usuario = usuarioservice.update(usuario);
		return ResponseEntity.noContent().build();
	}

}
