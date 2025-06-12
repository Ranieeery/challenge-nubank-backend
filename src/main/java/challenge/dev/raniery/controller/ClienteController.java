package challenge.dev.raniery.controller;

import challenge.dev.raniery.dto.ClientesDTO;
import challenge.dev.raniery.dto.ClientesResponseDTO;
import challenge.dev.raniery.dto.ContatoResponseDTO;
import challenge.dev.raniery.model.Clientes;
import challenge.dev.raniery.service.ClientesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClientesService clientesService;

    @PostMapping
    public ResponseEntity<Clientes> criar(@Valid @RequestBody ClientesDTO dto, UriComponentsBuilder uriBuilder) {
        Clientes cliente = clientesService.salvarClientes(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClientesResponseDTO>> listarTodos() {
        return ResponseEntity.ok(clientesService.listarTodosClientes());
    }

    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<ContatoResponseDTO>> listarContatos(@PathVariable Long id) {
        return ResponseEntity.ok(clientesService.listarTodosContatosPorCliente(id));
    }
}
