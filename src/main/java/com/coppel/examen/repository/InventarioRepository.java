package com.coppel.examen.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coppel.examen.model.Articulo;
import com.coppel.examen.repository.tools.Connector;
import com.coppel.examen.repository.tools.Respuesta;
import com.google.gson.Gson;

@Repository
public class InventarioRepository {
    Connector con = new Connector();
	Gson gson = new Gson();

	public boolean guardarArticulo(List<Articulo> art) throws SQLException{
		String parameters = "@jsonPolizas = NULL, "
            +"@jsonEmpleados = NULL, "
			+"@jsonArticulos = '" + gson.toJson(art) + "', "
			+"@tipo = 3";
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

	public List<Articulo> buscarArticulos(String id) throws SQLException{
		List<Articulo> arts = null;
		String parameters = "@idPoliza = NULL, "
            +"@idEmpleado = NULL, "
			+"@idArticulo = " + (id.isEmpty() ? "NULL" : ("'" + id + "'")) + ", "
			+"@tipo = 3";
		String spName = "ConsultarDatos";

		ResultSet rs = con.spCall(spName, parameters);

		if(rs != null && rs.next()){
			arts = new ArrayList<>();
			rs.beforeFirst();

			while(rs.next()){
				Articulo a = new Articulo();
				a.setSku(rs.getString("sku"));
				a.setNombre(rs.getString("nombre"));
				a.setCantidad(rs.getInt("cantidad"));

				arts.add(a);
			}
		}

		return arts;
	}

	public boolean borrarArticulo(String id) throws SQLException{
		String parameters = "@idPoliza = NULL, "
            +"@idEmpleado = NULL, "
			+"@idArticulo = '" + id + "', "
			+"@tipo = 3";
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

	public boolean actualizarArticulo(Articulo art) throws SQLException{
		String parameters = "@jsonPolizas = NULL, "
            +"@jsonEmpleados = NULL, "
			+"@jsonArticulos = '" + art.toString() + "', "
			+"@tipo = 3";
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
