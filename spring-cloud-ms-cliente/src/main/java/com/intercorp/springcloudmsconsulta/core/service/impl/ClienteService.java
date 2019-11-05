package com.intercorp.springcloudmsconsulta.core.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intercorp.springcloudmsconsulta.core.dao.IClienteDAO;
import com.intercorp.springcloudmsconsulta.core.negocio.bean.Cliente;
import com.intercorp.springcloudmsconsulta.core.negocio.bean.KPICliente;
import com.intercorp.springcloudmsconsulta.core.service.IClienteService;
import com.intercorp.springcloudmsconsulta.core.util.AppException;
import com.intercorp.springcloudmsconsulta.integracion.dto.ClienteDto;
import com.intercorp.springcloudmsconsulta.integracion.util.Util;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClienteDAO clienteDAO;

	@Override
	public void crearCliente(Cliente cliente) {
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setNombre(cliente.getNombre());
		clienteDto.setApellido(cliente.getApellido());
		clienteDto.setEdad(cliente.getEdad());
		clienteDto.setFechanac(new java.sql.Date(cliente.getFechanac().getTime()));
		try {
			clienteDAO.crearCliente(clienteDto);
		} catch (AppException e) {
			e.printStackTrace();
		}
	}

	@Override
	public KPICliente kpiClientes() {
		KPICliente kpi = new KPICliente();
		List<Cliente> list = new ArrayList<>();
		try {
			list = clienteDAO.getClientes();
		} catch (AppException e) {
			e.printStackTrace();
		}
		Integer count = list.size();
		int v[] = new int[count];
		
		int i = 0;
		for(Cliente c : list) {
			v[i] = c.getEdad();
			i++;
		}
		
		double prom = Util.promedio(v);
		kpi.setPromedioEdad(prom);
		double desv = Util.desviacion(v);
		kpi.setDesviacionEstandar(desv);
		return kpi;
	}

	@Override
	public List<Cliente> listClientes() {
		List<Cliente> list = new ArrayList<>();
		try {
			list = clienteDAO.getClientes();
		} catch (AppException e) {
			e.printStackTrace();
		}
		for (Cliente cliente : list)  {
			Calendar c = Calendar.getInstance();
			c.setTime(cliente.getFechanac());
			
			c.add(Calendar.YEAR, generateRandomIntIntRange(40, 60));
	        c.add(Calendar.MONTH, generateRandomIntIntRange(36, 108));
	        c.add(Calendar.DATE, generateRandomIntIntRange(360, 3240));
			
			cliente.setFechamuerte(c.getTime());
		}
		
		return list;
	}
	
	public static int generateRandomIntIntRange(int min, int max) {
	    Random r = new Random();
	    return r.nextInt((max - min) + 1) + min;
	}

}
