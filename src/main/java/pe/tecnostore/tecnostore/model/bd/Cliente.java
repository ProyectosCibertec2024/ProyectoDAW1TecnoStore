package pe.tecnostore.tecnostore.model.bd;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    private Integer idcliente;
    @Column(columnDefinition = "varchar(100)")
    private String nomcliente;
    @Column(columnDefinition = "varchar(100)")
    private String apecliente;
    @Column(columnDefinition = "varchar(8)")
    @Pattern(regexp = "^\\d{8}$", message = "DNI invalido")
    private String dnicliente;
    @Column(columnDefinition = "varchar(100)")
    private String direccion;
    @Column(columnDefinition = "varchar(100)")
    @Pattern(regexp = "^\\d{9,15}$", message = "El Telefono debe tener entre 9 y 15 digitos")
    private String telefono;

    @OneToMany(mappedBy = "cliente", targetEntity = Venta.class)
    private List<Venta> ventaList;
}