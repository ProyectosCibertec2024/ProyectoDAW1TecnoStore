package pe.tecnostore.tecnostore.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    private Integer idproducto;
    private String marca;
    private Integer idcategoria;
    private Integer stock;
    private String urlimagen;
    private String nombreimagen;
    private Double precio;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecharegistro;
    private String color;
    private String resolucion;
    private String procesador;
    private Double descuento;
    private String ram;
    private String espaciodisco;
    private String pantallatamaño;
    private Integer idproveedor;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idcategoria", insertable = false, updatable = false, foreignKey =
    @ForeignKey(name = "FkIdCategoriaToProducto"))
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idproveedor", insertable = false, updatable = false, foreignKey =
    @ForeignKey(name = "FkIdProveedorToProducto"))
    private Proveedor proveedor;

    @OneToMany(mappedBy = "producto", targetEntity = DetalleVenta.class)
    private List<DetalleVenta> detalleVentaList;
}
