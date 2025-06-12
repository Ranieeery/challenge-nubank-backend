package challenge.dev.raniery.controller;

import challenge.dev.raniery.dto.ContatoDTO;
import challenge.dev.raniery.dto.ContatoResponseDTO;
import challenge.dev.raniery.mapper.ContatoMapper;
import challenge.dev.raniery.model.Clientes;
import challenge.dev.raniery.model.Contatos;
import challenge.dev.raniery.repository.ClientesRepository;
import challenge.dev.raniery.repository.ContatosRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/contatos")
@RequiredArgsConstructor
public class ContatoController {

    private final ContatosRepository contatosRepository;
    private final ClientesRepository clientesRepository;
    private final ContatoMapper contatoMapper;

    @PostMapping
    public ResponseEntity<ContatoResponseDTO> criar(@Valid @RequestBody ContatoDTO dto) {
        Optional<Clientes> clientesOptional = clientesRepository.findById(dto.clienteId());

        if (clientesOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Contatos contato = contatoMapper.toModel(dto, clientesOptional.get());
        ContatoResponseDTO response = contatoMapper.toResponseDTO(contatosRepository.save(contato));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
