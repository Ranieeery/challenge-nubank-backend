package challenge.dev.raniery.controller;

import challenge.dev.raniery.dto.ContatoDTO;
import challenge.dev.raniery.dto.ContatoResponseDTO;
import challenge.dev.raniery.mapper.ContatoMapper;
import challenge.dev.raniery.model.Clientes;
import challenge.dev.raniery.service.ContatoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contatos")
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;
    private final ContatoMapper contatoMapper;

    @PostMapping
    public ResponseEntity<ContatoResponseDTO> criar(@Valid @RequestBody ContatoDTO dto) {
        Clientes clientes = contatoService.buscarClientes(dto.clienteId());

        if (clientes == null) {
            return ResponseEntity.notFound().build();
        }

        ContatoResponseDTO response = contatoMapper.toResponseDTO(contatoService.criarContato(dto, clientes));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
