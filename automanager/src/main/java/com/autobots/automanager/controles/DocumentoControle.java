package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.dtos.DocumentoDTO;
import com.autobots.automanager.servicos.DocumentoServicos;

@RestController
@RequestMapping("/documento")
public class DocumentoControle {
    @Autowired
    private DocumentoServicos servicos;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DocumentoDTO buscarDocumento(@PathVariable("id") long id) {
        return servicos.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DocumentoDTO> obterDocumentos() {
        return servicos.buscarDocumentos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DocumentoDTO cadastrarDocumento(@RequestBody DocumentoDTO documentoDTO) {
        return servicos.cadastrarDocumento(documentoDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DocumentoDTO atualizarDocumento(@PathVariable("id") long id, @RequestBody DocumentoDTO novosDados) {
        return servicos.atualizarDocumento(id, novosDados);
    }

    @SuppressWarnings("null")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCliente(@PathVariable("id") long id) {
        servicos.excluirDocumento(id);
    }
}
