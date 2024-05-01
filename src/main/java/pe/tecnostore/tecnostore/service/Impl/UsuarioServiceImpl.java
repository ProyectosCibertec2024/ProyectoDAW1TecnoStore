package pe.tecnostore.tecnostore.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.tecnostore.tecnostore.model.bd.Usuario;
import pe.tecnostore.tecnostore.repository.UsuarioRepository;
import pe.tecnostore.tecnostore.service.UsuarioService;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails u = null;
        try {
            Usuario bean = usuarioRepository.iniciarSesion(username);
            Set<GrantedAuthority> rol = new HashSet<GrantedAuthority>();
            rol.add(new SimpleGrantedAuthority(bean.getRol().getDescripcion()));
            u = new User(username, bean.getPass(), rol);
        } catch (Exception e) {
            System.out.println("Error en : " + e.getMessage());
        }
        return u;
    }
}
