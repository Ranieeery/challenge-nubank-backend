package challenge.dev.raniery.dto;

public record ContatoResponseDTO(

    Long id,

    String nome,

    String telefone,

    String email,

    Long clientId) {
}
