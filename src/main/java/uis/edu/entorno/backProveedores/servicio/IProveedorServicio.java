/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entorno.backProveedores.servicio;

import java.util.List;
import uis.edu.entorno.backProveedores.modelo.Proveedor;

/**
 *
 * @author Carlos
 */
public interface IProveedorServicio {
    
    List<Proveedor> getProveedor();
    
    Proveedor nuevoProveedor(Proveedor proveedor);
    
    Proveedor buscarProveedor(Long id);
    
    int borrarProveedor(Long id);
}
