package challenge.dev.raniery.mapper;

import challenge.dev.raniery.dto.ClientesDTO;
import challenge.dev.raniery.dto.ClientesResponseDTO;
import challenge.dev.raniery.dto.ContatoDTO;
import challenge.dev.raniery.dto.ContatoResponseDTO;
import challenge.dev.raniery.model.Clientes;
import challenge.dev.raniery.model.Contatos;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteMapper {

    public Clientes toModel(ClientesDTO dto) {
        Clientes clientes = new Clientes();
        clientes.setNome(dto.nome());

        if (dto.contatos() != null && !dto.contatos().isEmpty()) {
            List<Contatos> contatos = dto.contatos().stream()
                .map(c -> toContatoModel(c, clientes))
                .toList();
            clientes.setContatos(contatos);
        }

        return clientes;
    }

    public Contatos toContatoModel(ContatoDTO dto, Clientes cliente) {
        Contatos contato = new Contatos();
        contato.setNome(dto.nome());
        contato.setEmail(dto.email());
        contato.setTelefone(dto.telefone());
        contato.setClientes(cliente);
        return contato;
    }

    public ClientesResponseDTO toResponseDTO(Clientes clientes) {
        return new ClientesResponseDTO(
            clientes.getId(),
            clientes.getNome(),
            clientes.getContatos().stream()
                .map(this::toContatoResponseDTO)
                .toList()
        );
    }

    public ContatoResponseDTO toContatoResponseDTO(Contatos contato) {
        return new ContatoResponseDTO(
            contato.getId(),
            contato.getNome(),
            contato.getTelefone(),
            contato.getEmail(),
            contato.getClientes().getId()
        );
    }

    public List<ClientesResponseDTO> toResponseDTO(List<Clientes> clientes) {
        return clientes.stream()
            .map(this::toResponseDTO)
            .toList();
    }

    public List<ContatoResponseDTO> toContatoResponseDTO(List<Contatos> contatos) {
        return contatos.stream()
            .map(this::toContatoResponseDTO)
            .toList();
    }
}
