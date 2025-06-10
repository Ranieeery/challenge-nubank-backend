package challenge.dev.raniery.dto;

import java.util.List;

public record ClientesResponseDTO(

    Long id,

    String nome,

    List<ContatoResponseDTO> contatos) {
}
