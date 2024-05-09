package pe.tecnostore.tecnostore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.tecnostore.tecnostore.model.bd.Usuario;
import pe.tecnostore.tecnostore.service.interfaces.IUsuarioService;

import java.util.Date;


@SpringBootTest
class TecnostoreApplicationTests {

	@Autowired
	private IUsuarioService usuarioService;

	@Test
	void contextLoads() {
		try{
			Usuario u = new Usuario();
			u.setIdusuario(3);
			u.setNombre("Sebastian Otara");
			u.setUsername("sebas@gmail.com");
			u.setPassword("sebas123");
			u.setRep_pass("sebas123");
			u.setUrlfoto("https://firebasestorage.googleapis.com/v0/b/proyectoandroid-fe9b6.appspot.com/o/users%2Fuser-sebas.jpg?alt=media&token=8e12390f-fdeb-47fa-8275-a7957a7c59d0");
			u.setNombrefoto("user-sebas.jpg");
			Date d = new Date();
			u.setFecharegistro(d);
			u.setDni("72616171");
			u.setIdrol(1);
			usuarioService.guardarUsuario(u);
		}catch (Exception e) {
			System.out.println("Error en : " + e.getLocalizedMessage());
		}
	}

}
