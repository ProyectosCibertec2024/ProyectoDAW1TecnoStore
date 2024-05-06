package pe.tecnostore.tecnostore.service;

import pe.tecnostore.tecnostore.model.bd.EnlaceMenu;
import pe.tecnostore.tecnostore.model.bd.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario guardarUsuario(Usuario usuario);
    int obtenerId();
    Usuario iniciarSesion(String username);
    List<EnlaceMenu> traerEnlaceUsuario(int codRol);
}
