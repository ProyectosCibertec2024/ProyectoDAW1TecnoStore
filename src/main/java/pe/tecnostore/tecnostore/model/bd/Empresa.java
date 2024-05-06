package pe.tecnostore.tecnostore.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    private Integer idempresa;
    private String nomempresa;
    private String direccion;
    private String telefono;
    private Integer idtipoempresa;
    private String email;
    private String ruc;
    private Integer idtipobanco;

    @OneToMany(mappedBy = "empresa", targetEntity = Proveedor.class)
    private List<Proveedor> lstProveedor;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "tipobanco_empresa", joinColumns = @JoinColumn(name = "idempresa"),
                foreignKey = @ForeignKey(name = "FkIdEmpresaToTipoBancoEmpresa"),
                inverseJoinColumns = @JoinColumn(name = "idtipobanco"),
                inverseForeignKey = @ForeignKey(name = "FkIdTipoEmpresaToTipoBancoEmpresa"))
    private List<TipoBanco> tipoBancoList;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idtipoempresa", insertable = false, updatable = false,
    foreignKey = @ForeignKey(name = "FkIdEmpresaToTipoEmpresa"))
    private TipoEmpresa tipoEmpresa;
}
