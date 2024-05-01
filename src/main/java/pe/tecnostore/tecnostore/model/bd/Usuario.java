package pe.tecnostore.tecnostore.model.bd;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
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
    private String correo;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "contraseña")
    private String pass;
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
