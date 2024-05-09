package pe.tecnostore.tecnostore.service.interfaces;

import pe.tecnostore.tecnostore.model.bd.EnlaceMenu;
import pe.tecnostore.tecnostore.model.bd.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario guardarUsuario(Usuario usuario);
    int obtenerId();
    Usuario iniciarSesion(String username);
    List<EnlaceMenu> traerEnlaceUsuario(int codRol);
}
