package com.intercorp.springcloudmsconsulta.core.dao;

import java.util.List;

import com.intercorp.springcloudmsconsulta.core.negocio.bean.Cliente;
import com.intercorp.springcloudmsconsulta.core.util.AppException;
import com.intercorp.springcloudmsconsulta.integracion.dto.ClienteDto;

public interface IClienteDAO {

	public void crearCliente(ClienteDto clienteDto) throws AppException;

	public List<Cliente> getClientes() throws AppException;

}
