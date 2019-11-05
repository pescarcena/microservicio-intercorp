package com.intercorp.springcloudmsconsulta.core.util;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		ResponseEntity<DatosConexion> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8090/mproperties/datosconexion", DatosConexion.class);
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		DatosConexion datosConexion = responseEntity.getBody();
		dataSource.setDriverClassName(datosConexion.getDriverclassname());
		dataSource.setUrl(datosConexion.getUrl());
		dataSource.setUsername(datosConexion.getUsername());
		dataSource.setPassword(datosConexion.getPassword());
		return dataSource;
	}
}