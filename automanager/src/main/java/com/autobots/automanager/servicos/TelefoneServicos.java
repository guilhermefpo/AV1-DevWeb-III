package com.autobots.automanager.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.dtos.TelefoneDTO;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.excecoes.ClienteNaoEncontradoException;
import com.autobots.automanager.excecoes.TelefoneNaoEncontradoException;
import com.autobots.automanager.modelo.TelefoneAtualizador;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.TelefoneRepositorio;

@Service
public class TelefoneServicos {

        @Autowired
        private TelefoneRepositorio repositorio;

        @Autowired
        private ClienteRepositorio clienteRepositorio;

        @Autowired
        private TelefoneAtualizador atualizador;

        @Autowired
        private ModelMapper modelMapper;

        public List<TelefoneDTO> buscarTelefones() {
                List<Telefone> telefones = repositorio.findAll();

                return telefones.stream()
                                .map(telefone -> modelMapper.map(telefone, TelefoneDTO.class))
                                .collect(Collectors.toList());
        }

        public TelefoneDTO buscarPorId(Long id) {
                @SuppressWarnings("null")
                Telefone telefone = repositorio.findById(id)
                                .orElseThrow(() -> new TelefoneNaoEncontradoException(id));

                return modelMapper.map(telefone, TelefoneDTO.class);
        }

        public TelefoneDTO atualizarTelefone(Long id, TelefoneDTO novosDados) {
                @SuppressWarnings("null")
                Telefone telefone = repositorio.findById(id)
                                .orElseThrow(() -> new TelefoneNaoEncontradoException(id));

                Telefone dadosNovos = modelMapper.map(novosDados, Telefone.class);

                atualizador.atualizar(telefone, dadosNovos);

                @SuppressWarnings("null")
                Telefone telefoneSalvo = repositorio.save(telefone);

                return modelMapper.map(telefoneSalvo, TelefoneDTO.class);
        }

        public TelefoneDTO cadastrarTelefone(TelefoneDTO novoTelefone, long id) {

                Cliente cliente = clienteRepositorio.findById(id)
                                .orElseThrow(() -> new ClienteNaoEncontradoException(id));

                Telefone telefone = modelMapper.map(novoTelefone, Telefone.class);

                cliente.getTelefones().add(telefone);

                clienteRepositorio.save(cliente);

                return modelMapper.map(telefone, TelefoneDTO.class);
        }

        public void excluirTelefone(Long id) {

                Cliente cliente = clienteRepositorio.findAll().stream()
                                .filter(c -> c.getTelefones().stream()
                                                .anyMatch(telefone -> telefone.getId().equals(id)))
                                .findFirst()
                                .orElseThrow(() -> new TelefoneNaoEncontradoException(id));

                cliente.getTelefones()
                                .removeIf(telefone -> telefone.getId().equals(id));

                clienteRepositorio.save(cliente);
        }

}