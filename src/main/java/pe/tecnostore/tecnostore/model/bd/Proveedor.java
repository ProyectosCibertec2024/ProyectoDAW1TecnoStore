package pe.tecnostore.tecnostore.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    private Integer idproveedor;
    private String nomproveedor;
    private String telefono;
    private String correo;
    private Integer idtipoproveedor;
    private Boolean estado;
    private LocalDate fecharegistro;
    private Integer idempresa;

    @OneToMany(mappedBy = "proveedor", targetEntity = Producto.class)
    private List<Producto> productoList;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idempresa", insertable = false, updatable = false,
    foreignKey = @ForeignKey(name = "FkIdEmpresaToEmpresa"))
    private Empresa empresa;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "tipoprov_proveedor", joinColumns = @JoinColumn(name = "idproveedor"),
            inverseJoinColumns = @JoinColumn(name = "idtipoproveedor"),
            foreignKey = @ForeignKey(name = "FkProveedorToManyTipoProvProv"),
            inverseForeignKey = @ForeignKey(name = "FkTipoProveedorManyTipoProvProv"))
    private List<TipoProveedor> tipoProveedors;
}
