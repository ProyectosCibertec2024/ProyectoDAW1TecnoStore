package pe.tecnostore.tecnostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.tecnostore.tecnostore.model.bd.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value = "SELECT coalesce(max(c.idcliente), 0 ) + 1 FROM cliente c", nativeQuery = true)
    int obtenerIdCliente();
}
