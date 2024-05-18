package pe.tecnostore.tecnostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.tecnostore.tecnostore.model.bd.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query(value = "SELECT coalesce(max(p.idproducto), 0) + 1 FROM producto p ", nativeQuery = true)
    int obtenerIdProducto();
}
