package challenge.dev.raniery.dto;

import java.util.List;

public record ClientesDTO(

    String nome,

    List<ContatoDTO> contatos) {
}
