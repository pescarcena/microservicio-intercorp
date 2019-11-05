package com.intercorp.springcloudmsconsulta.core.negocio.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Model Cliente")
public class Cliente {

	@JsonIgnore
	private Integer codigo;
	
	@ApiModelProperty(value = "Los nombres del cliente", required = true)
	private String nombre;
	
	@ApiModelProperty(value = "Los apellidos del cliente", required = true)
	private String apellido;
	
	@ApiModelProperty(value = "Edad del cliente", required = true)
	private Integer edad;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@ApiModelProperty(value = "Fecha de nacimiento del cliente yyyy-MM-dd", required = true)
	private Date fechanac;
		
	@JsonFormat(pattern="yyyy-MM-dd")
	@ApiModelProperty(value = "Fecha probable de muerte del cliente yyyy-MM-dd", required = true)
	private Date fechamuerte;
	
	public Cliente() {
		
	}

	public Cliente(Integer codigo, String nombre, String apellido, Integer edad, Date fechanac) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechanac = fechanac;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechanac() {
		return fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	public Date getFechamuerte() {
		return fechamuerte;
	}

	public void setFechamuerte(Date fechamuerte) {
		this.fechamuerte = fechamuerte;
	}

}
