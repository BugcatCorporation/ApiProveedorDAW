package pe.bugcatcorporation.ApiProveedor.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pe.bugcatcorporation.ApiProveedor.dao.ProveedorRepository;
import pe.bugcatcorporation.ApiProveedor.dto.ProveedorDto;
import pe.bugcatcorporation.ApiProveedor.entity.Producto;
import pe.bugcatcorporation.ApiProveedor.entity.Proveedor;

@Service
@Slf4j
public class ProveedorServiceImpl implements ProveedorService {
    
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private ApiRestClient apiRestClient;

    @Override
    public List<Proveedor> findAll() {
        log.info("Obteniendo todos los proveedores.");
        return proveedorRepository.findAll();     
    }

    @Override
    public Page<Proveedor> findPage(int page, int size) {
        log.info("Obteniendo página {} de proveedores con tamaño {}.", page, size);
        return proveedorRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public ProveedorDto findById(Long id) {
        log.info("Buscando proveedor por ID: {}.", id);
        Proveedor proveedor = proveedorRepository.findById(id).get();
        Producto producto = apiRestClient.findByProductoSK(proveedor.getProductoSK());        
        ProveedorDto prvDto = new ProveedorDto();        
        prvDto.setId(proveedor.getId());
        prvDto.setNombreProveedor(proveedor.getNombreProveedor());
        prvDto.setRUC(proveedor.getRUC());
        prvDto.setDireccion(proveedor.getDireccion());
        prvDto.setCorreo(proveedor.getCorreo());
        prvDto.setProducto(producto);
        
        return prvDto;
    }

    @Override
    public Proveedor findByNombreProveedor(String nombreProveedor) {
        log.info("Buscando proveedor por nombre: {}.", nombreProveedor);
        return proveedorRepository.findByNombreProveedor(nombreProveedor);
    }

    @Override
    public Proveedor add(Proveedor proveedor) {
        log.info("Agregando nuevo proveedor: {}.", proveedor);
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor update(Proveedor proveedor) {
        log.info("Actualizando proveedor: {}.", proveedor);
        var proveedorDB = proveedorRepository.findById(proveedor.getId()).get();
        proveedorDB.setNombreProveedor(proveedor.getNombreProveedor());
        proveedorDB.setRUC(proveedor.getRUC());
        proveedorDB.setCorreo(proveedor.getCorreo());
        proveedorDB.setDireccion(proveedor.getDireccion());
        
        return proveedorRepository.save(proveedorDB);
    }

    @Override
    public void delete(Long id) {
        log.info("Eliminando proveedor con ID: {}.", id);
        var proveedorDB = proveedorRepository.findById(id).get();
        proveedorRepository.delete(proveedorDB);
    }
}
