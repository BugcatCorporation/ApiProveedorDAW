
package pe.bugcatcorporation.ApiProveedor.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.bugcatcorporation.ApiProveedor.entity.Producto;

@FeignClient(value = "producto-service",
        url = "http://localhost:8089/")

public interface ApiRestClient {
    @GetMapping("api/v1/producto/findByProductoSK/{productoSK}")
    Producto findByProductoSK(@PathVariable String productoSK);
}
