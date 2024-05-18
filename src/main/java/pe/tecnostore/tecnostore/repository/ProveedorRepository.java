package pe.tecnostore.tecnostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.tecnostore.tecnostore.model.bd.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    @Query(value = "SELECT coalesce(max(p.idproveedor), 0) + 1 FROM proveedor p", nativeQuery = true)
    int obtenerIdProveedor();
}
