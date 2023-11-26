package pe.bugcatcorporation.ApiProveedor.service;

import java.util.List;
import org.springframework.data.domain.Page;
import pe.bugcatcorporation.ApiProveedor.dto.ProveedorDto;
import pe.bugcatcorporation.ApiProveedor.entity.Proveedor;


public interface ProveedorService {
    
    public List<Proveedor> findAll();
    public Page<Proveedor> findPage(int page, int size);
    public ProveedorDto findById(Long id);
    public Proveedor findByNombreProveedor(String nombreProveedor);
    public Proveedor add (Proveedor proveedor);
    public Proveedor update(Proveedor proveedor);
   
    public void delete (Long id);
    
}
