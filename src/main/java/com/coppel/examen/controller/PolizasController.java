package com.coppel.examen.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.coppel.examen.controller.schemes.RespuestaCtrl;
import com.coppel.examen.model.Polizas;
import com.coppel.examen.serviceimpl.PolizaServiceImpl;

@RestController
public class PolizasController {
    private final String region = "pol";

    PolizaServiceImpl service = new PolizaServiceImpl();

    @PostMapping(region+"/buscarPolizas")
	public RespuestaCtrl buscarPolizas(@RequestBody Polizas pol) {
		RespuestaCtrl res;

		if(pol != null){
			try{
				List<Polizas> lista = service.buscarPolizas(""+(pol.getIdPolizas() == 0 ? "" : pol.getIdPolizas()));
				
				if(lista != null){
					res = new RespuestaCtrl(false, 1, lista);
				}else{
					res = new RespuestaCtrl(true, 0, "No se encontro ninguna Poliza");
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

    @PostMapping(region+"/guardarPoliza")
	public ResponseEntity<RespuestaCtrl> guardarPoliza(@RequestBody Polizas pol) {
		RespuestaCtrl res;

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.buildAndExpand()
			.toUri();

		if(pol != null && pol.getIdPolizas() != 0){
			try{
				if(service.guardarPoliza(pol)){
					res = new RespuestaCtrl(false, 1, "Poliza guardada con éxito");
				}else{
					res = new RespuestaCtrl(true, 0, "No se pudo guardar esta Poliza");
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

	@PostMapping(region+"/borrarPoliza")
	public ResponseEntity<RespuestaCtrl> borrarPoliza(@RequestBody Polizas pol) {
		RespuestaCtrl res;

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.buildAndExpand()
			.toUri();

		if(pol != null && pol.getIdPolizas() != 0){
			try{
				if(service.borrarPoliza(""+pol.getIdPolizas())){
					res = new RespuestaCtrl(false, 1, "Poliza borrada con éxito");
				}else{
					res = new RespuestaCtrl(true, 0, "No se pudo borrar o no se encontró esta Poliza");
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

	@PostMapping(region+"/actualizarPoliza")
	public ResponseEntity<RespuestaCtrl> actualizarPoliza(@RequestBody Polizas pol) {
		RespuestaCtrl res;

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.buildAndExpand()
			.toUri();

		if(pol != null && pol.getIdPolizas() != 0){
			try{
				if(service.actualizarPoliza(pol)){
					res = new RespuestaCtrl(false, 1, "Poliza actualizada con éxito");
				}else{
					res = new RespuestaCtrl(true, 0, "No se pudo actualizar o no se encontró esta Poliza");
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
