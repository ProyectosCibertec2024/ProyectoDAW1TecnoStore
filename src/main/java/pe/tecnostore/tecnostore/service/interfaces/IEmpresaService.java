package pe.tecnostore.tecnostore.service.interfaces;

import pe.tecnostore.tecnostore.model.bd.Empresa;

import java.util.List;

public interface IEmpresaService {
    public List<Empresa> empresaList();
    public void guardarEmpresa(Empresa empresa);
    public void eliminarEmpresa(int id);
    public Empresa buscarEmpresa(int id);
    public int obtenerIdGenerado();
}
