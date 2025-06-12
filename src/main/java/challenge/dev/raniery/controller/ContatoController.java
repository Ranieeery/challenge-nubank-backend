package challenge.dev.raniery.controller;

import challenge.dev.raniery.dto.ContatoDTO;
import challenge.dev.raniery.model.Clientes;
import challenge.dev.raniery.model.Contatos;
import challenge.dev.raniery.repository.ClientesRepository;
import challenge.dev.raniery.repository.ContatosRepository;
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

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody ContatoDTO dto) {
        Optional<Clientes> clientesOptional = clientesRepository.findById(dto.clienteId());

        if (clientesOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        Contatos contato = new Contatos();
        contato.setNome(dto.nome());
        contato.setTelefone(dto.telefone());
        contato.setEmail(dto.email());
        contato.setClientes(clientesOptional.get());

        Contatos contatoSalvo = contatosRepository.save(contato);
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoSalvo);
    }
}
