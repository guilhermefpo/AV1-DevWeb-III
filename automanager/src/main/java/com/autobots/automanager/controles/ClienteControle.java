package com.autobots.automanager.controles;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.dtos.ClienteDTO;
import com.autobots.automanager.dtos.ClienteRespostaDTO;
import com.autobots.automanager.servicos.ClienteServicos;

@RestController
@RequestMapping("/cliente")
@Validated
public class ClienteControle {

	@Autowired
	private ClienteServicos servicos;

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ClienteRespostaDTO obterCliente(@PathVariable("id") long id) {
		return servicos.buscarPorId(id);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ClienteRespostaDTO> obterClientes() {
		return servicos.buscarClientes();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteRespostaDTO cadastrarCliente(@Valid @RequestBody ClienteDTO clienteDto) {
		return servicos.cadastrarCliente(clienteDto);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ClienteRespostaDTO atualizarCliente(@PathVariable("id") long id, @RequestBody ClienteDTO atualizacao) {
		return servicos.atualizarCliente(id, atualizacao);
	}

	@SuppressWarnings("null")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirCliente(@PathVariable("id") long id) {
		servicos.excluirCliente(id);
	}

}