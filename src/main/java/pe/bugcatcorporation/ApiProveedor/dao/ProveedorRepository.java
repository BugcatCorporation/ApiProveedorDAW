package pe.bugcatcorporation.ApiProveedor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.bugcatcorporation.ApiProveedor.entity.Proveedor;


public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    
    public Proveedor findByNombreProveedor(String nombreProveedor);
    
}
