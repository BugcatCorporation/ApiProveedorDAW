package pe.bugcatcorporation.ApiProveedor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiProveedorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProveedorApplication.class, args);
	}

}
