package challenge.dev.raniery.service;

import challenge.dev.raniery.dto.ClientesDTO;
import challenge.dev.raniery.dto.ClientesResponseDTO;
import challenge.dev.raniery.dto.ContatoResponseDTO;
import challenge.dev.raniery.mapper.ClienteMapper;
import challenge.dev.raniery.model.Clientes;
import challenge.dev.raniery.repository.ClientesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientesService {

    private final ClientesRepository clientesRepository;
    private final ClienteMapper clienteMapper;

    public Clientes salvarClientes(ClientesDTO dto) {
        Clientes clientes = clienteMapper.toModel(dto);
        return clientesRepository.save(clientes);
    }

    public List<ClientesResponseDTO> listarTodosClientes() {
        List<Clientes> clientes = clientesRepository.findAll();
        return clienteMapper.toResponseDTO(clientes);
    }

    public List<ContatoResponseDTO> listarTodosContatosPorCliente(Long clientId) {
        Clientes cliente = clientesRepository.findById(clientId)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return clienteMapper.toContatoResponseDTO(cliente.getContatos());
    }
}
