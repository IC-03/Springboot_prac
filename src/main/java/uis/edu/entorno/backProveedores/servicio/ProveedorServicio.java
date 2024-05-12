/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entorno.backProveedores.servicio;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uis.edu.entorno.backProveedores.modelo.Proveedor;
import uis.edu.entorno.backProveedores.repositorio.ProveedorRepositorio;

/**
 *
 * @author Carlos
 */
@Service
@Transactional
public class ProveedorServicio implements IProveedorServicio{

    @Autowired
    ProveedorRepositorio proveedorRepositorio;
    
    
    //listar
    @Override
    public List<Proveedor> getProveedor() {
        return proveedorRepositorio.findAll();
    }

    //crear
    @Override
    public Proveedor nuevoProveedor(Proveedor proveedor) {
        return proveedorRepositorio.save(proveedor);
    }

    //buscar
    @Override
    public Proveedor buscarProveedor(Long id) {
        Proveedor proveedor = null;
        proveedor = proveedorRepositorio.findById(id).orElse(null);
        if(proveedor == null){
            return null;
        }
        return proveedor;
    }

    @Override
    public int borrarProveedor(Long id) {
        proveedorRepositorio.deleteById(id);
        return 1;
    }
    
}
