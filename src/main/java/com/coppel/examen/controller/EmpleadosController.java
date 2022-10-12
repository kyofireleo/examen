package com.coppel.examen.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.coppel.examen.controller.schemes.RespuestaCtrl;
import com.coppel.examen.model.Empleado;
import com.coppel.examen.serviceimpl.EmpleadoServiceImpl;

@RestController
public class EmpleadosController {
	private final String region = "emp";
	EmpleadoServiceImpl service = new EmpleadoServiceImpl();
    
	@PostMapping(region+"/buscarEmpleados")
	public RespuestaCtrl buscarEmpleados(@RequestBody Empleado emp) {
		RespuestaCtrl res;

		if(emp != null){
			try{
				List<Empleado> lista = service.buscarEmpleados(""+(emp.getIdEmpleado() == 0 ? "" : emp.getIdEmpleado()));
				
				if(lista != null){
					res = new RespuestaCtrl(false, 1, lista);
				}else{
					res = new RespuestaCtrl(true, 0, "No se encontro ningún empleado");
				}
			}catch(Exception ex){
				ex.printStackTrace();
				res = new RespuestaCtrl(true, 0, ex.getMessage());
			}
		}else{
			res = new RespuestaCtrl(true, 0, "No se aceptan valores nulos");
		}
		
		return res;
	}

    @PostMapping(region+"/guardarEmpleado")
	public ResponseEntity<RespuestaCtrl> guardarEmpleado(@RequestBody Empleado emp) {
		RespuestaCtrl res;

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.buildAndExpand()
			.toUri();

		if(emp != null && emp.getIdEmpleado() != 0){
			try{
				if(service.guardarEmpleado(emp)){
					res = new RespuestaCtrl(false, 1, "Empleado guardado con éxito");
				}else{
					res = new RespuestaCtrl(true, 0, "No se pudo guardar este empleado");
				}
			}catch(Exception ex){
				ex.printStackTrace();
				res = new RespuestaCtrl(true, 0, ex.getMessage());
			}
		}else{
			res = new RespuestaCtrl(true, 0, "No se aceptan valores nulos");
		}

		return ResponseEntity.created(uri)
				.body(res);
	}

	@PostMapping(region+"/borrarEmpleado")
	public ResponseEntity<RespuestaCtrl> borrarEmpleado(@RequestBody Empleado emp) {
		RespuestaCtrl res;

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.buildAndExpand()
			.toUri();

		if(emp != null && emp.getIdEmpleado() != 0){
			try{
				if(service.borrarEmpleado(""+emp.getIdEmpleado())){
					res = new RespuestaCtrl(false, 1, "Empleado borrado con éxito");
				}else{
					res = new RespuestaCtrl(true, 0, "No se pudo borrar o no se encontró este empleado");
				}
			}catch(Exception ex){
				ex.printStackTrace();
				res = new RespuestaCtrl(true, 0, ex.getMessage());
			}
		}else{
			res = new RespuestaCtrl(true, 0, "No se aceptan valores nulos");
		}

		return ResponseEntity.created(uri)
				.body(res);
	}

	@PostMapping(region+"/actualizarEmpleado")
	public ResponseEntity<RespuestaCtrl> actualizarEmpleado(@RequestBody Empleado emp) {
		RespuestaCtrl res;

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.buildAndExpand()
			.toUri();

		if(emp != null && emp.getIdEmpleado() != 0){
			try{
				if(service.actualizarEmpleado(emp)){
					res = new RespuestaCtrl(false, 1, "Empleado actualizado con éxito");
				}else{
					res = new RespuestaCtrl(true, 0, "No se pudo actualizar o no se encontró este empleado");
				}
			}catch(Exception ex){
				ex.printStackTrace();
				res = new RespuestaCtrl(true, 0, ex.getMessage());
			}
		}else{
			res = new RespuestaCtrl(true, 0, "No se aceptan valores nulos");
		}

		return ResponseEntity.created(uri)
				.body(res);
	}

}
