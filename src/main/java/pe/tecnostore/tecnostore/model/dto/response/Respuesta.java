package pe.tecnostore.tecnostore.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Respuesta {
    private Boolean respuesta;
    private String mensaje;
}
