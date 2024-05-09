package pe.tecnostore.tecnostore.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pe.tecnostore.tecnostore.service.interfaces.IEmpresaService;

@SessionAttributes({"ENLACES","USUARIO"})

@AllArgsConstructor
@Controller
@RequestMapping("/inventario")
public class EmpresaController {
    private IEmpresaService empresaService;

    @GetMapping("/empresa")
    public String empresa(Model model) {
        model.addAttribute("empresa", empresaService.empresaList());
        return "backoffice/empresa/frmempresa";
    }


}
