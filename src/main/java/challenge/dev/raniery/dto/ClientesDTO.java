package challenge.dev.raniery.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ClientesDTO(

    @NotBlank
    String nome,

    List<ContatoDTO> contatos) {
}
