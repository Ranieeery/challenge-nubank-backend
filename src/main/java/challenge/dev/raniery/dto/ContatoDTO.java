package challenge.dev.raniery.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContatoDTO(

    @NotBlank(message = "Nome é obrigatório")
    String nome,
    
    @NotBlank(message = "Telefone é obrigatório")
    String telefone,
    
    @Email(message = "Email deve ter formato válido")
    @NotBlank(message = "Email é obrigatório")
    String email,
    
    @NotNull(message = "Cliente ID é obrigatório")
    Long clienteId) {
}
