package challenge.dev.raniery.repository;

import challenge.dev.raniery.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
