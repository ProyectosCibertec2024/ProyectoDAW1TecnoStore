package pe.tecnostore.tecnostore.model.bd;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    private Integer idusuario;
    private String nombre;
    @NotEmpty(message = "Ingrese El Email")
    @Column(name = "correo")
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty(message = "Ingrese El Password")
    @Column(name = "contraseña")
    private String password;
    @Column(name = "rep_contra")
    private String rep_pass;
    private String urlfoto;
    private String nombrefoto;
    @Column(columnDefinition = "date")
    private Date fecharegistro;
    @Column(length = 8, columnDefinition = "char(8)")
    private String dni;
    private int idrol;

    @JoinColumn(name = "idrol", insertable = false, updatable = false)
    @ManyToOne
    private Rol rol;
}
