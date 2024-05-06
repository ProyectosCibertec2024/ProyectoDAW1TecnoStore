package pe.tecnostore.tecnostore.controller.backoffice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pe.tecnostore.tecnostore.model.bd.EnlaceMenu;
import pe.tecnostore.tecnostore.model.bd.Usuario;
import pe.tecnostore.tecnostore.repository.UsuarioRepository;
import pe.tecnostore.tecnostore.service.UsuarioService;

import java.util.List;

@SessionAttributes({"ENLACES","USUARIO"})

@AllArgsConstructor
@Controller
public class UsuarioController {

    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;

    @GetMapping("/principal")
    public String menu(Authentication auth, Model model) {
        if (auth != null) {
            String username = auth.getName();
            Usuario u = usuarioRepository.iniciarSesion(username);
            List<EnlaceMenu> lista = usuarioRepository.traerEnlaceUsuario(u.getRol().getIdrol());
            model.addAttribute("ENLACES", lista);
            model.addAttribute("USUARIO", u);
            return "backoffice/principal/principal";
        }
        return "backoffice/principal/principal";
    }

    @GetMapping("/login")
    public String logueo() {
        return "backoffice/logueo/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
