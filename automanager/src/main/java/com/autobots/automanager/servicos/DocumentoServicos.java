package com.autobots.automanager.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.dtos.DocumentoDTO;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.excecoes.DocumentoNaoEncontradoException;
import com.autobots.automanager.modelo.DocumentoAtualizador;
import com.autobots.automanager.repositorios.DocumentoRepositorio;

@Service
public class DocumentoServicos {
    @Autowired
    private DocumentoRepositorio repositorio;

    @Autowired
    private DocumentoAtualizador atualizador;

    @Autowired
    private ModelMapper modelMapper;

    public List<DocumentoDTO> buscarDocumentos() {
        List<Documento> documentos = repositorio.findAll();

        return documentos.stream()
                .map(documento -> modelMapper.map(documento, DocumentoDTO.class))
                .collect(Collectors.toList());
    }

    public DocumentoDTO buscarPorId(Long id) {
        @SuppressWarnings("null")
        Documento documento = repositorio.findById(id)
                .orElseThrow(() -> new DocumentoNaoEncontradoException(id));

        return modelMapper.map(documento, DocumentoDTO.class);
    }

    public DocumentoDTO atualizarDocumento(Long id, DocumentoDTO novosDados) {
        @SuppressWarnings("null")
        Documento documento = repositorio.findById(id)
                .orElseThrow(() -> new DocumentoNaoEncontradoException(id));

        Documento dadosNovos = modelMapper.map(novosDados, Documento.class);
        atualizador.atualizar(documento, dadosNovos);

        @SuppressWarnings("null")
        Documento documentoSalvo = repositorio.save(documento);

        return modelMapper.map(documentoSalvo, DocumentoDTO.class);
    }

    public DocumentoDTO cadastrarDocumento(DocumentoDTO novoDocumento) {
        Documento documento = modelMapper.map(novoDocumento, Documento.class);

        @SuppressWarnings("null")
        Documento documentoSalvo = repositorio.save(documento);

        return modelMapper.map(documentoSalvo, DocumentoDTO.class);
    }

    public void excluirDocumento(long id) {
        Documento documento = repositorio.getById(id);

        repositorio.delete(documento);
    }
}
