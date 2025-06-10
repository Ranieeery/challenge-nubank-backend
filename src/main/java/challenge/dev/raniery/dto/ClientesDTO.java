package challenge.dev.raniery.dto;

import challenge.dev.raniery.model.Contatos;

import java.util.List;

public record ClientesDTO(

    String nome,

    List<Contatos> contatos) {
}
