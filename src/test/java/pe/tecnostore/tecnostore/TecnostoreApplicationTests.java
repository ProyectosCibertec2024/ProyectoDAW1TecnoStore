package pe.tecnostore.tecnostore;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pe.tecnostore.tecnostore.model.bd.Usuario;
import pe.tecnostore.tecnostore.service.UsuarioService;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootTest
class TecnostoreApplicationTests {

	@Autowired
	private UsuarioService usuarioService;

	@Test
	void contextLoads() {
		try{
			String pwd = "edgar123";
			Usuario u = new Usuario();
			u.setIdusuario(2);
			u.setNombre("Edgar");
			u.setCorreo("edgarcito@gmail.com");
			BCryptPasswordEncoder by = new BCryptPasswordEncoder();
			String pass = by.encode(pwd);
			u.setPass(pass);
			u.setRep_pass("edgar123");
			u.setUrlfoto("vacio");
			u.setNombrefoto("vacio");
			Date d = new Date();
			u.setFecharegistro(d);
			u.setDni("82717281");
			u.setIdrol(1);
			usuarioService.guardarUsuario(u);
		}catch (Exception e) {
			System.out.println("Error en : " + e.getLocalizedMessage());
		}
	}

}
