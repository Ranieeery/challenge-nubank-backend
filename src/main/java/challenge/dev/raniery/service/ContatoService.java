package challenge.dev.raniery.service;

import challenge.dev.raniery.dto.ContatoDTO;
import challenge.dev.raniery.mapper.ContatoMapper;
import challenge.dev.raniery.model.Clientes;
import challenge.dev.raniery.model.Contatos;
import challenge.dev.raniery.repository.ClientesRepository;
import challenge.dev.raniery.repository.ContatosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ClientesRepository clientesRepository;
    private final ContatosRepository contatosRepository;
    private final ContatoMapper contatoMapper;

    public Clientes buscarClientes(Long id) {
        Optional<Clientes> clientesOptional = clientesRepository.findById(id);

        return clientesOptional.orElse(null);
    }

    public Contatos criarContato(ContatoDTO dto, Clientes clientes) {
        Contatos contato = contatoMapper.toModel(dto, clientes);

        return contatosRepository.save(contato);
    }
}