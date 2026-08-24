package com.autobots.automanager.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.dtos.EnderecoDTO;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.excecoes.EnderecoNaoEncontradoException;
import com.autobots.automanager.modelo.EnderecoAtualizador;
import com.autobots.automanager.repositorios.EnderecoRepositorio;

@Service
public class EnderecoService {

  @Autowired
  private EnderecoRepositorio repositorio;

  @Autowired
  private EnderecoAtualizador atualizador;

  @Autowired
  private ModelMapper modelMapper;

  public List<EnderecoDTO> buscarEnderecos() {
    List<Endereco> enderecos = repositorio.findAll();

    return enderecos.stream()
        .map(endereco -> modelMapper.map(endereco, EnderecoDTO.class))
        .collect(Collectors.toList());
  }

  public EnderecoDTO buscarPorId(Long id) {
    @SuppressWarnings("null")
    Endereco endereco = repositorio.findById(id)
        .orElseThrow(() -> new EnderecoNaoEncontradoException(id));

    return modelMapper.map(endereco, EnderecoDTO.class);
  }

  public EnderecoDTO atualizarEndereco(Long id, EnderecoDTO novosDados) {
    @SuppressWarnings("null")
    Endereco endereco = repositorio.findById(id)
        .orElseThrow(() -> new EnderecoNaoEncontradoException(id));

    Endereco dadosNovos = modelMapper.map(novosDados, Endereco.class);

    atualizador.atualizar(endereco, dadosNovos);

    @SuppressWarnings("null")
    Endereco enderecoSalvo = repositorio.save(endereco);

    return modelMapper.map(enderecoSalvo, EnderecoDTO.class);
  }

  public EnderecoDTO cadastrarEndereco(EnderecoDTO novoEndereco) {
    Endereco endereco = modelMapper.map(novoEndereco, Endereco.class);

    @SuppressWarnings("null")
    Endereco enderecoSalvo = repositorio.save(endereco);

    return modelMapper.map(enderecoSalvo, EnderecoDTO.class);
  }

  public void excluirEndereco(long id) {
    Endereco endereco = repositorio.findById(id)
        .orElseThrow(() -> new EnderecoNaoEncontradoException(id));

    repositorio.delete(endereco);

  }
}
