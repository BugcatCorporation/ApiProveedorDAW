package pe.bugcatcorporation.ApiProveedor.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.bugcatcorporation.ApiProveedor.dto.ProveedorDto;
import pe.bugcatcorporation.ApiProveedor.entity.Proveedor;
import pe.bugcatcorporation.ApiProveedor.service.ProveedorService;

@RestController
@Slf4j
@RequestMapping("api/v1/proveedor")
public class ProveedorController {
    
    @Autowired
    private ProveedorService ps;
         
    @GetMapping("/findAll")
    public ResponseEntity<List<Proveedor>> findAll() {
        try {
            log.info("Obteniendo todos los proveedores.");
            List<Proveedor> proveedores = ps.findAll();
            return new ResponseEntity<>(proveedores, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener todos los proveedores.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findPage/page/{page}/size/{size}")
    public ResponseEntity<Page<Proveedor>> findPage(@PathVariable int page, @PathVariable int size) {
        try {
            log.info("Obteniendo página {} de proveedores con tamaño {}.", page, size);
            Page<Proveedor> proveedoresPage = ps.findPage(page, size);
            return new ResponseEntity<>(proveedoresPage, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener la página de proveedores.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/findById/{id}")
    public ResponseEntity<ProveedorDto> findById(@PathVariable Long id) {
        try {
            log.info("Buscando proveedor por ID: {}.", id);
            ProveedorDto proveedor = ps.findById(id);
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar proveedor por ID.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByNombreProveedor/{nombreProveedor}")
    public ResponseEntity<Proveedor> findByNombreProveedor(@PathVariable String nombreProveedor) {
        try {
            log.info("Buscando proveedor por nombre: {}.", nombreProveedor);
            Proveedor proveedor = ps.findByNombreProveedor(nombreProveedor);
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar proveedor por nombre.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Proveedor> add(@RequestBody Proveedor proveedor) {
        try {
            log.info("Agregando nuevo proveedor: {}.", proveedor);
            Proveedor nuevoProveedor = ps.add(proveedor);
            return new ResponseEntity<>(nuevoProveedor, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al agregar nuevo proveedor.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Proveedor> update(@RequestBody Proveedor proveedor) {     
        try {
            log.info("Actualizando proveedor: {}.", proveedor);
            Proveedor proveedorActualizado = ps.update(proveedor);
            return new ResponseEntity<>(proveedorActualizado, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al actualizar proveedor.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            log.info("Eliminando proveedor con ID: {}.", id);
            ps.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.error("Error al eliminar proveedor.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
