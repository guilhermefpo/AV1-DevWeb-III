package com.autobots.automanager.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.dtos.ClienteDTO;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.excecoes.ClienteNaoEncontradoException;
import com.autobots.automanager.modelo.ClienteAtualizador;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@Service
public class ClienteServicos {

    @Autowired
    private ClienteRepositorio repositorio;

    @Autowired
    private ClienteAtualizador atualizador;

    @Autowired
    private ModelMapper modelMapper;

    public List<ClienteDTO> buscarClientes() {
        List<Cliente> clientes = repositorio.findAll();

        return clientes.stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarPorId(Long id) {
        @SuppressWarnings("null")
        Cliente cliente = repositorio.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException(id));

        return modelMapper.map(cliente, ClienteDTO.class);
    }

    public ClienteDTO atualizarCliente(Long id, ClienteDTO novosDados) {
        @SuppressWarnings("null")
        Cliente cliente = repositorio.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException(id));

        Cliente dadosNovos = modelMapper.map(novosDados, Cliente.class);

        atualizador.atualizar(cliente, dadosNovos);

        @SuppressWarnings("null")
        Cliente clienteSalvo = repositorio.save(cliente);

        return modelMapper.map(clienteSalvo, ClienteDTO.class);
    }

    public ClienteDTO cadastrarCliente(ClienteDTO novoCliente) {
        Cliente cliente = modelMapper.map(novoCliente, Cliente.class);

        @SuppressWarnings("null")
        Cliente clienteSalvo = repositorio.save(cliente);

        return modelMapper.map(clienteSalvo, ClienteDTO.class);
    }

    public void excluirCliente(long id) {
        Cliente cliente = repositorio.getById(id);

        repositorio.delete(cliente);
    }
}