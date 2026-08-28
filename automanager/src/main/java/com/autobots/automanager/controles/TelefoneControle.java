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

import com.autobots.automanager.dtos.TelefoneDTO;
import com.autobots.automanager.servicos.TelefoneServicos;

@RestController
@RequestMapping("/telefone")
public class TelefoneControle {

    @Autowired
    private TelefoneServicos servicos;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TelefoneDTO obterTelefone(@PathVariable("id") long id) {
        return servicos.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TelefoneDTO> obterTelefones() {
        return servicos.buscarTelefones();
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public TelefoneDTO cadastrarTelefone(@RequestBody TelefoneDTO telefoneDto, @PathVariable("id") long id) {
        return servicos.cadastrarTelefone(telefoneDto, id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TelefoneDTO atualizarTelefone(
            @PathVariable("id") long id,
            @RequestBody TelefoneDTO atualizacao) {

        return servicos.atualizarTelefone(id, atualizacao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirTelefone(@PathVariable("id") long id) {
        servicos.excluirTelefone(id);
    }
}