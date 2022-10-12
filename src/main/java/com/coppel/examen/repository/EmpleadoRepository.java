package com.coppel.examen.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.coppel.examen.model.Empleado;
import com.coppel.examen.repository.tools.Connector;
import com.coppel.examen.repository.tools.Respuesta;
import com.google.gson.Gson;

@Repository
public class EmpleadoRepository {
	Connector con = new Connector();
	Gson gson = new Gson();

	public boolean guardarEmpleado(Empleado emp) throws SQLException{
		String parameters = "@jsonPolizas = NULL, "
			+"@jsonEmpleados = '" + emp.toString() + "', "
			+"@jsonArticulos = NULL, "
			+"@tipo = 2";
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

	public List<Empleado> buscarEmpleados(String id) throws SQLException{
		List<Empleado> emps = null;
		String parameters = "@idPoliza = NULL, "
			+"@idEmpleado = " + (id.isEmpty() ? "NULL" : id) + ", "
			+"@idArticulo = NULL, "
			+"@tipo = 2";
		String spName = "ConsultarDatos";

		ResultSet rs = con.spCall(spName, parameters);

		if(rs != null && rs.next()){
			emps = new ArrayList<>();
			rs.beforeFirst();

			while(rs.next()){
				Empleado e = new Empleado();
				e.setIdEmpleado(rs.getInt("idEmpleado"));
				e.setNombre(rs.getString("nombre"));
				e.setApellido(rs.getString("apellido"));
				e.setPuesto(rs.getString("puesto"));

				emps.add(e);
			}
		}

		return emps;
	}

	public boolean borrarEmpleado(String id) throws SQLException{
		String parameters = "@idPoliza = NULL, "
			+"@idEmpleado = " + id + ", "
			+"@idArticulo = NULL, "
			+"@tipo = 2";
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

	public boolean actualizarEmpleado(Empleado emp) throws SQLException{
		String parameters = "@jsonPolizas = NULL, "
			+"@jsonEmpleados = '" + emp.toString() + "', "
			+"@jsonArticulos = NULL, "
			+"@tipo = 2";
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
