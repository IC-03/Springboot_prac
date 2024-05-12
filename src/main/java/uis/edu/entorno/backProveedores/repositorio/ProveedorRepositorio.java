/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entorno.backProveedores.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.entorno.backProveedores.modelo.Proveedor;

public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long>{
    
    
}
