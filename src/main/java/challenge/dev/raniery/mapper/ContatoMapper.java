package challenge.dev.raniery.mapper;

import challenge.dev.raniery.dto.ContatoDTO;
import challenge.dev.raniery.dto.ContatoResponseDTO;
import challenge.dev.raniery.model.Clientes;
import challenge.dev.raniery.model.Contatos;
import org.springframework.stereotype.Component;

@Component
public class ContatoMapper {

    public Contatos toModel(ContatoDTO dto, Clientes cliente) {
        Contatos contato = new Contatos();
        contato.setNome(dto.nome());
        contato.setTelefone(dto.telefone());
        contato.setEmail(dto.email());
        contato.setClientes(cliente);
        return contato;
    }

    public ContatoResponseDTO toResponseDTO(Contatos contato) {
        return new ContatoResponseDTO(
            contato.getId(),
            contato.getNome(),
            contato.getTelefone(),
            contato.getEmail(),
            contato.getClientes().getId()
        );
    }
}
