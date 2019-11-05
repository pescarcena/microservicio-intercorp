package com.intercorp.springcloudmanagementproperties.conexion;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("conexion")
public class ConfiguracionDataSource {

	private String driverclassname;
	private String url;
	private String username;
	private String password;

	public ConfiguracionDataSource() {
	}

	public String getDriverclassname() {
		return driverclassname;
	}

	public void setDriverclassname(String driverclassname) {
		this.driverclassname = driverclassname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
