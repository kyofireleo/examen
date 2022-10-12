package com.coppel.examen.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.coppel.examen.model.Polizas;
import com.coppel.examen.repository.tools.Connector;
import com.coppel.examen.repository.tools.Respuesta;
import com.google.gson.Gson;

@Repository
public class PolizaRepository {
    Connector con = new Connector();
	Gson gson = new Gson();

	public boolean guardarPoliza(Polizas pol) throws SQLException{
		String parameters = "@jsonPolizas = '" + pol.toString() + "', "
            +"@jsonEmpleados = NULL, "
			+"@jsonArticulos = NULL, "
			+"@tipo = 1";
		String spName = "GuardarDatos";

		ResultSet rs = con.spCall(spName, parameters);

		if(rs != null && rs.next()){
			Respuesta respuesta = gson.fromJson(rs.getString("respuesta"), Respuesta.class);
			
			if(respuesta.getStatus() == Respuesta.OK)
				return true;
			else
				throw new SQLException(respuesta.getMessage());
		}else{
			return false;
		}
	}

	public List<Polizas> buscarPolizas(String id) throws SQLException{
		List<Polizas> pols = null;
		String parameters = "@idPoliza = " + (id.isEmpty() ? "NULL" : id) + ", "
            +"@idEmpleado = NULL, "
			+"@idArticulo = NULL, "
			+"@tipo = 1";
		String spName = "ConsultarDatos";

		ResultSet rs = con.spCall(spName, parameters);

		if(rs != null && rs.next()){
			pols = new ArrayList<>();
			rs.beforeFirst();

			while(rs.next()){
				Polizas p = new Polizas();
                p.setIdPolizas(rs.getInt("idPolizas"));
                p.setEmpleadoGenero(rs.getInt("EmpleadoGenero"));
				p.setSku(rs.getString("sku"));
				p.setCantidad(rs.getInt("cantidad"));
                p.setFecha(rs.getString("fecha"));

				pols.add(p);
			}
		}

		return pols;
	}

	public boolean borrarPoliza(String id) throws SQLException{
		String parameters = "@idPoliza = " + id + ", "
            +"@idEmpleado = NULL, "
			+"@idArticulo = NULL, "
			+"@tipo = 1";
		String spName = "EliminarDatos";

		ResultSet rs = con.spCall(spName, parameters);

		if(rs != null && rs.next()){
			Respuesta respuesta = gson.fromJson(rs.getString("respuesta"), Respuesta.class);
			
			if(respuesta.getStatus() == Respuesta.OK)
				return true;
			else
				throw new SQLException(respuesta.getMessage());
		}else{
			return false;
		}
	}

	public boolean actualizarPoliza(Polizas pol) throws SQLException{
		String parameters = "@jsonPolizas = '" + pol.toString() + "', " 
            +"@jsonEmpleados = NULL, "
			+"@jsonArticulos = NULL, "
			+"@tipo = 1";
		String spName = "ActualizarDatos";

		ResultSet rs = con.spCall(spName, parameters);

		if(rs != null && rs.next()){
			Respuesta respuesta = gson.fromJson(rs.getString("respuesta"), Respuesta.class);
			
			if(respuesta.getStatus() == Respuesta.OK)
				return true;
			else
				throw new SQLException(respuesta.getMessage());
		}else{
			return false;
		}
	}
}
