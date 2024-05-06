package pe.tecnostore.tecnostore.model.bd;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tipo_empresa")
public class TipoEmpresa {
    @Id
    private Integer idtipoempresa;
    private String nomempresa;

    @OneToMany(mappedBy = "tipoEmpresa")
    private List<Empresa> empresaList;
}
