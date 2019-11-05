package com.intercorp.springcloudmsconsulta.core.negocio.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Model KPICliente")
public class KPICliente {

	@ApiModelProperty(value = "Promedio de la edad de los clientes")
	private double promedioEdad;

	@ApiModelProperty(value = "Desviacion estandar de la edad de los clientes")
	private double desviacionEstandar;

	public double getPromedioEdad() {
		return promedioEdad;
	}

	public void setPromedioEdad(double promedioEdad) {
		this.promedioEdad = promedioEdad;
	}

	public double getDesviacionEstandar() {
		return desviacionEstandar;
	}

	public void setDesviacionEstandar(double desviacionEstandar) {
		this.desviacionEstandar = desviacionEstandar;
	}

}
