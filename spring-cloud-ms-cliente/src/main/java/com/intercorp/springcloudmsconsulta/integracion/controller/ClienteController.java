package com.intercorp.springcloudmsconsulta.integracion.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intercorp.springcloudmsconsulta.core.negocio.bean.Cliente;
import com.intercorp.springcloudmsconsulta.core.negocio.bean.KPICliente;
import com.intercorp.springcloudmsconsulta.core.service.IClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "Persona Administracion")
public class ClienteController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IClienteService clienteService;

	public ClienteController() {
	}

	@PostMapping(path = "/creacliente")
	@ApiOperation(value = "Crear un cliente", notes = "Crea un cliente basado en sus datos")
	public void crearCliente(
			@ApiParam(value = "Cliente que se va a guardar", required = true) @Valid @RequestBody Cliente cliente) {
		logger.info("crearCliente " + cliente.getFechanac());
		clienteService.crearCliente(cliente);
	}

	@GetMapping(path = "/kpideclientes")
	@ApiOperation(value = "Indicador clave de rendimiento", notes = "Muestra el promedio, desviacion estandar")
	public KPICliente kpiClientes() {
		logger.info("kpiClientes");
		return clienteService.kpiClientes();
	}
	
	@GetMapping(path = "/listclientes")
	@ApiOperation(value = "Lista de clientes", notes = "Lista de clientes mas fecha probable de muerte")
	public List<Cliente> listClientes() {
		logger.info("listClientes");
		return clienteService.listClientes();
	}
}
