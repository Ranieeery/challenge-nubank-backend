package challenge.dev.raniery.repository;

import challenge.dev.raniery.model.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatosRepository extends JpaRepository<Contatos, Long> {
}
