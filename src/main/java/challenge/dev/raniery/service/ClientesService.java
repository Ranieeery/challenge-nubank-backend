package challenge.dev.raniery.service;

import challenge.dev.raniery.dto.ClientesDTO;
import challenge.dev.raniery.dto.ClientesResponseDTO;
import challenge.dev.raniery.dto.ContatoResponseDTO;
import challenge.dev.raniery.model.Clientes;
import challenge.dev.raniery.model.Contatos;
import challenge.dev.raniery.repository.ClientesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientesService {

    private ClientesRepository clientesRepository;

    public Clientes salvarClientes(ClientesDTO dto) {

        Clientes clientes = new Clientes();
        clientes.setNome(dto.nome());

        if (dto.contatos() != null && !dto.contatos().isEmpty()) {
            List<Contatos> contatos = dto.contatos().stream().map(c -> {
                Contatos contato = new Contatos();
                contato.setNome(c.nome());
                contato.setEmail(c.email());
                contato.setTelefone(c.telefone());
                contato.setClientes(clientes);

                return contato;
            }).toList();
            clientes.setContatos(contatos);
        }

        return clientesRepository.save(clientes);
    }

    public List<ClientesResponseDTO> listarTodosClientes() {

        return clientesRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<ContatoResponseDTO> listarTodosContatosPorCliente(Long clientId) {

        Clientes cliente = clientesRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return cliente.getContatos().stream().map(c -> new ContatoResponseDTO(
            c.getId(),
            c.getNome(),
            c.getTelefone(),
            c.getEmail(),
            c.getClientes().getId()
        )).toList();
    }

    public ClientesResponseDTO toDto(Clientes clientes) {

        return new ClientesResponseDTO(
            clientes.getId(),
            clientes.getNome(),
            clientes.getContatos().stream().map(c -> new ContatoResponseDTO(
                c.getId(),
                c.getNome(),
                c.getTelefone(),
                c.getEmail(),
                c.getClientes().getId()
            )).toList()
        );
    }
}
