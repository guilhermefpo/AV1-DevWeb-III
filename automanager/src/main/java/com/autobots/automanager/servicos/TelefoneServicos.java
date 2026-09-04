package com.autobots.automanager.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.dtos.TelefoneDTO;
import com.autobots.automanager.dtos.TelefoneRespostaDTO;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.excecoes.ClienteNaoEncontradoException;
import com.autobots.automanager.excecoes.TelefoneJaCadastradoException;
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

        public List<TelefoneRespostaDTO> buscarTelefones() {
                List<Telefone> telefones = repositorio.findAll();

                return telefones.stream()
                                .map(telefone -> modelMapper.map(
                                                telefone,
                                                TelefoneRespostaDTO.class))
                                .collect(Collectors.toList());
        }

        public TelefoneRespostaDTO buscarPorId(Long id) {

                Telefone telefone = repositorio.findById(id)
                                .orElseThrow(() -> new TelefoneNaoEncontradoException(id));

                return modelMapper.map(
                                telefone,
                                TelefoneRespostaDTO.class);
        }

        public TelefoneRespostaDTO atualizarTelefone(
                        Long id,
                        TelefoneDTO novosDados) {

                Telefone telefone = repositorio.findById(id)
                                .orElseThrow(() -> new TelefoneNaoEncontradoException(id));

                Telefone dadosNovos = modelMapper.map(
                                novosDados,
                                Telefone.class);

                atualizador.atualizar(telefone, dadosNovos);

                Telefone telefoneSalvo = repositorio.save(telefone);

                return modelMapper.map(
                                telefoneSalvo,
                                TelefoneRespostaDTO.class);
        }

        public TelefoneRespostaDTO cadastrarTelefone(
                        TelefoneDTO novoTelefone,
                        Long id) {

                Cliente cliente = clienteRepositorio.findById(id)
                                .orElseThrow(() -> new ClienteNaoEncontradoException(id));

                if (repositorio.existsByNumero(novoTelefone.getNumero())) {
                        throw new TelefoneJaCadastradoException(
                                        "Já existe um telefone cadastrado com esse número.");
                }

                Telefone telefone = modelMapper.map(
                                novoTelefone,
                                Telefone.class);

                cliente.getTelefones().add(telefone);

                clienteRepositorio.save(cliente);

                return modelMapper.map(
                                telefone,
                                TelefoneRespostaDTO.class);
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
