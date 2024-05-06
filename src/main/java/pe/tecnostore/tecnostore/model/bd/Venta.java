package pe.tecnostore.tecnostore.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "venta")
public class Venta {
    @Id
    private Integer idventa;
    private String numeroventa;
    private Integer idusuario;
    private Integer idcliente;
    private Double subtotal;
    private Double impuestototal;
    private Double total;
    private LocalDate fecharegistro;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idusuario", insertable = false, updatable = false,
                foreignKey = @ForeignKey(name = "FkIdUsuarioToVenta"))
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcliente", insertable = false, updatable = false,
                foreignKey = @ForeignKey(name = "FkIdClienteToCliente"))
    private Cliente cliente;

    @OneToMany(mappedBy = "venta", targetEntity = DetalleVenta.class)
    private List<DetalleVenta> detalleVentaList;
}
