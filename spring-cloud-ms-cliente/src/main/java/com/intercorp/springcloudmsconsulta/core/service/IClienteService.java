package com.intercorp.springcloudmsconsulta.core.service;

import java.util.List;

import com.intercorp.springcloudmsconsulta.core.negocio.bean.Cliente;
import com.intercorp.springcloudmsconsulta.core.negocio.bean.KPICliente;

public interface IClienteService {

	public void crearCliente(Cliente cliente);

	public KPICliente kpiClientes();

	public List<Cliente> listClientes();

}
