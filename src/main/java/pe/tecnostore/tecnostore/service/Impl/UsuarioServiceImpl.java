package pe.tecnostore.tecnostore.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    private BCryptPasswordEncoder encoder;

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Usuario bean = usuarioRepository.iniciarSesion(username);
            if (bean == null) {
                throw new UsernameNotFoundException("Usuario no encontrado");
            }
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority(bean.getRol().getDescripcion()));
            return new User(username, bean.getPassword(), authorities);
        } catch (Exception e) {
            throw new UsernameNotFoundException("Error al cargar el usuario", e);
        }
    }

    /*public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails u = null;
        try {
            Usuario bean = usuarioRepository.iniciarSesion(username);
            if (bean == null) {
                throw new UsernameNotFoundException("Usuario no encontrado");
            }
            Set<GrantedAuthority> rol = new HashSet<GrantedAuthority>();
            rol.add(new SimpleGrantedAuthority(bean.getRol().getDescripcion()));
            u = new User(username, bean.getPassword(), rol);
        } catch (Exception e) {
            System.out.println("Error en : " + e.getMessage());
        }
        return u;
    }*/
}
