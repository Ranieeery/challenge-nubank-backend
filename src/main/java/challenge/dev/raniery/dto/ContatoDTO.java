package challenge.dev.raniery.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContatoDTO(

    @NotBlank
    String nome,

    @NotBlank
    String telefone,

    @Email
    @NotBlank
    String email,

    @NotNull
    Long clienteId) {
}
