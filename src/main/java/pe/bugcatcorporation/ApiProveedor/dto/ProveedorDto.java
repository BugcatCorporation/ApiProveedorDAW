package pe.bugcatcorporation.ApiProveedor.dto;

import lombok.Data;
import pe.bugcatcorporation.ApiProveedor.entity.Producto;

@Data
public class ProveedorDto {
    private Long id;    
    private String nombreProveedor;
    private String RUC;
    private String direccion;
    private String correo;
    
    private Producto producto;
    
}