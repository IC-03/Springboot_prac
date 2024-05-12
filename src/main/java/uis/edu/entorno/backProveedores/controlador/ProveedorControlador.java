/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entorno.backProveedores.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uis.edu.entorno.backProveedores.modelo.Proveedor;
import uis.edu.entorno.backProveedores.servicio.ProveedorServicio;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/proveedores")
public class ProveedorControlador {
    
    @Autowired
    ProveedorServicio proveedorServicio;
    
    //listar
    @GetMapping("/list")
    public List<Proveedor> cargarProveedores(){
        return proveedorServicio.getProveedor();
    }
    
    //listar por ID
    @GetMapping("/list/{id}")
    public Proveedor buscarPorId(@PathVariable Long id){
        return proveedorServicio.buscarProveedor(id);
    }
    
    // agregar
    @PostMapping("/")
    public ResponseEntity<Proveedor> agregar(@RequestBody Proveedor proveedor){
        Proveedor obj = proveedorServicio.nuevoProveedor(proveedor);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    //Actualizar
    @PutMapping("/")
    public ResponseEntity<Proveedor> editar(@RequestBody Proveedor proveedor){
        Proveedor obj = proveedorServicio.buscarProveedor(proveedor.getId());
        if(obj != null){
            obj.setCiudad(proveedor.getCiudad());
            obj.setDireccion(proveedor.getDireccion());
            obj.setNit(proveedor.getNit());
            obj.setNombre(proveedor.getNombre());
            obj.setTelefono(proveedor.getTelefono());
            proveedorServicio.nuevoProveedor(obj);
        }else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    //Borrar
    @DeleteMapping("/{id}")
    public ResponseEntity<Proveedor> eliminar(@PathVariable Long id){
        Proveedor obj = proveedorServicio.buscarProveedor(id);
        if(obj != null){
            proveedorServicio.borrarProveedor(id);
        } else{
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
