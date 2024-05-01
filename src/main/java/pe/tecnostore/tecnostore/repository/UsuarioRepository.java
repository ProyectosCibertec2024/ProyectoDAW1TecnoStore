package pe.tecnostore.tecnostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.tecnostore.tecnostore.model.bd.EnlaceMenu;
import pe.tecnostore.tecnostore.model.bd.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("Select coalesce(MAX(u.idusuario), 0) + 1 From Usuario u")
    int obtenerId();

    @Query("Select u from Usuario u where u.username=?1")
    public Usuario iniciarSesion(String username);

    @Query("Select e from RolEnlace re join re.enlace e where re.rol.idrol=?1")
    public List<EnlaceMenu> traerEnlaceUsuario(int codRol);
}
