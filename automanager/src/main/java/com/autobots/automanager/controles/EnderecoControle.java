package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.dtos.EnderecoDTO;
import com.autobots.automanager.servicos.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoControle {

    @Autowired
    private EnderecoService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EnderecoDTO obterEndereco(@PathVariable("id") long id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EnderecoDTO> obterEnderecos() {
        return service.buscarEnderecos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnderecoDTO cadastrarEndereco(@RequestBody EnderecoDTO enderecoDto) {
        return service.cadastrarEndereco(enderecoDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EnderecoDTO atualizarEndereco(@PathVariable("id") long id, @RequestBody EnderecoDTO atualizacao) {
        return service.atualizarEndereco(id, atualizacao);
    }

    @SuppressWarnings("null")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirEndereco(@PathVariable("id") long id) {
        service.excluirEndereco(id);
    }
}
