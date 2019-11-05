package com.intercorp.springcloudmanagementproperties.conexion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatosConexionController {

	@Autowired
	private ConfiguracionDataSource dataSource;
	
	@GetMapping("datosconexion")
	public DatosConexion getDatosConexion() {
		DatosConexion datosconexion = new DatosConexion(dataSource.getDriverclassname(), dataSource.getUrl(),
				dataSource.getUsername(), dataSource.getPassword());
		return datosconexion;
	}

}
