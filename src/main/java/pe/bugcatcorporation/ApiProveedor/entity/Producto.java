
package pe.bugcatcorporation.ApiProveedor.entity;
import lombok.Data;

@Data
public class Producto {
    private Long id;
    private String nombreProducto;
    private String desripcion;
    private String productoSK;
    private int stock;
    private Double precio;
    
}
