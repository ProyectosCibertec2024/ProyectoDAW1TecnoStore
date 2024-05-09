package pe.tecnostore.tecnostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.tecnostore.tecnostore.model.bd.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    @Query(value = "SELECT coalesce(max(e.idempresa), 0) + 1 FROM Empresa e")
    int obtenerCod();
}
