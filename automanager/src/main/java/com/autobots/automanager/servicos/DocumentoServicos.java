package com.autobots.automanager.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.dtos.DocumentoDTO;
import com.autobots.automanager.dtos.DocumentoRespostaDTO;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.excecoes.ClienteNaoEncontradoException;
import com.autobots.automanager.excecoes.DocumentoJaCadastradoException;
import com.autobots.automanager.excecoes.DocumentoNaoEncontradoException;
import com.autobots.automanager.modelo.DocumentoAtualizador;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.DocumentoRepositorio;

@Service
public class DocumentoServicos {

    @Autowired
    private DocumentoRepositorio repositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private DocumentoAtualizador atualizador;

    @Autowired
    private ModelMapper modelMapper;

    public List<DocumentoRespostaDTO> buscarDocumentos() {
        List<Documento> documentos = repositorio.findAll();

        return documentos.stream()
                .map(documento -> modelMapper.map(documento, DocumentoRespostaDTO.class))
                .collect(Collectors.toList());
    }

    public DocumentoRespostaDTO buscarPorId(Long id) {

        Documento documento = repositorio.findById(id)
                .orElseThrow(() -> new DocumentoNaoEncontradoException(id));

        return modelMapper.map(documento, DocumentoRespostaDTO.class);
    }

    public DocumentoRespostaDTO atualizarDocumento(
            Long id,
            DocumentoDTO novosDados) {

        @SuppressWarnings("null")
        Documento documento = repositorio.findById(id)
                .orElseThrow(() -> new DocumentoNaoEncontradoException(id));

        Documento dadosNovos = modelMapper.map(novosDados, Documento.class);

        atualizador.atualizar(documento, dadosNovos);

        @SuppressWarnings("null")
        Documento documentoSalvo = repositorio.save(documento);

        return modelMapper.map(
                documentoSalvo,
                DocumentoRespostaDTO.class);
    }

    public DocumentoRespostaDTO cadastrarDocumento(
            DocumentoDTO novoDocumento,
            Long id) {

        @SuppressWarnings("null")
        Cliente cliente = clienteRepositorio.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException(id));

        if (repositorio.existsByNumero(novoDocumento.getNumero())) {
            throw new DocumentoJaCadastradoException(
                    "Já existe um documento cadastrado com esse número.");
        }

        Documento documento = modelMapper.map(
                novoDocumento,
                Documento.class);

        cliente.getDocumentos().add(documento);

        clienteRepositorio.save(cliente);

        return modelMapper.map(
                documento,
                DocumentoRespostaDTO.class);
    }

    public void excluirDocumento(Long id) {
        @SuppressWarnings("null")
        Documento documento = repositorio.findById(id)
                .orElseThrow(() -> new DocumentoNaoEncontradoException(id));

        Cliente cliente = clienteRepositorio.findAll().stream()
                .filter(c -> c.getDocumentos().contains(documento))
                .findFirst()
                .orElseThrow(() -> new DocumentoNaoEncontradoException(id));

        cliente.getDocumentos().remove(documento);

        clienteRepositorio.save(cliente);
    }
}
