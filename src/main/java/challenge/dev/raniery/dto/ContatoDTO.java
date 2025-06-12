package challenge.dev.raniery.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ContatoDTO(

    @NotBlank
    String nome,

    @NotBlank
    String telefone,

    @Email
    @NotBlank
    String email,

    @NotBlank
    Long clienteId) {
}
