package pe.bugcatcorporation.ApiProveedor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Proveedor {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombreProveedor;
    private String RUC;
    private String direccion;
    private String correo;
    
    private String productoSK;
    
    
    
}
