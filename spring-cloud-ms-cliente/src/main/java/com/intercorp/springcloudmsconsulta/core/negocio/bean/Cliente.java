package com.intercorp.springcloudmsconsulta.core.negocio.bean;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Model Cliente")
public class Cliente {

	@JsonIgnore
	private Integer codigo;

	@NotBlank
	@ApiModelProperty(notes = "Los nombres del cliente", example = "Juan", required = true, position = 0)
	private String nombre;

	@NotBlank
	@ApiModelProperty(notes = "Los apellidos del cliente", example = "Rojas", required = true, position = 1)
	private String apellido;

	@NotNull
	@Min(0)
    @Max(100)
	@ApiModelProperty(notes = "La edad del cliente", example = "45", required = true, position = 2)
	private Integer edad;

	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(notes = "Fecha de nacimiento del cliente yyyy-MM-dd", example = "1980-01-10", required = true, position = 3)
	private Date fechanac;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(notes = "Fecha probable de muerte del cliente yyyy-MM-dd", example = "2030-02-11", position = 4)
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
