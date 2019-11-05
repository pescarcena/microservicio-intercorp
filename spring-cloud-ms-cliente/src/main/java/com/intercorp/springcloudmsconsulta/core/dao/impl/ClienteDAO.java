package com.intercorp.springcloudmsconsulta.core.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.intercorp.springcloudmsconsulta.core.dao.IClienteDAO;
import com.intercorp.springcloudmsconsulta.core.negocio.bean.Cliente;
import com.intercorp.springcloudmsconsulta.core.util.AppException;
import com.intercorp.springcloudmsconsulta.core.util.Conexion;
import com.intercorp.springcloudmsconsulta.integracion.dto.ClienteDto;

@Repository
public class ClienteDAO implements IClienteDAO {

	@Override
	public void crearCliente(ClienteDto clienteDto) throws AppException {
		Conexion con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = new Conexion();
		} catch (Exception e) {
			throw new AppException(e.getMessage());
		}
		String SQL = "insert INTO esqmicroservicios1706.TBL_CLIENTE_2(nombre,apellido,edad,fechanac) "
				+ "VALUES (?,?,?,?)";
		try {
			con.getConexion().setAutoCommit(false);
			pstmt = con.getConexion().prepareStatement(SQL);
			pstmt.setString(1, clienteDto.getNombre());
			pstmt.setString(2, clienteDto.getApellido());
			pstmt.setInt(3, clienteDto.getEdad());
			pstmt.setDate(4, clienteDto.getFechanac());
			int row = pstmt.executeUpdate();
			System.out.println(row);
			con.getConexion().commit();
		} catch (Exception e) {
			throw new AppException(e.getMessage());
		} finally {
			try {
				con.closeResources(con.getConexion(), rs, null, null, pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Cliente> getClientes() throws AppException {
		List<Cliente> list = new ArrayList<>();
		Conexion con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = new Conexion();
		} catch (Exception e) {
			throw new AppException(e.getMessage());
		}
		String SQL = "SELECT c.nombre, c.apellido, c.edad, c.fechanac"
				+ " FROM esqmicroservicios1706.TBL_CLIENTE_2 c ";
		try {
			con.getConexion().setAutoCommit(false);
			pstmt = con.getConexion().prepareStatement(SQL);
			rs = pstmt.executeQuery();
			con.getConexion().commit();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellido(rs.getString("apellido"));
				cliente.setEdad(rs.getInt("edad"));
				cliente.setFechanac(rs.getDate("fechanac"));
				list.add(cliente);
				cliente = null;
			}
		} catch (Exception e) {
			throw new AppException(e.getMessage());
		} finally {
			try {
				con.closeResources(con.getConexion(), rs, null, null, pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
