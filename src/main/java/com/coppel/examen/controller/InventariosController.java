package com.coppel.examen.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.coppel.examen.controller.schemes.RespuestaCtrl;
import com.coppel.examen.model.Articulo;
import com.coppel.examen.serviceimpl.InventarioServiceImpl;

@RestController
public class InventariosController {
	private final String region = "inv";

    InventarioServiceImpl service = new InventarioServiceImpl();
    
	@PostMapping(region+"/buscarArticulos")
	public RespuestaCtrl buscarArticulos(@RequestBody Articulo art) {
		RespuestaCtrl res;

		if(art != null && art.getSku() != null){
			try{
				List<Articulo> lista = service.buscarArticulos(""+art.getSku());
				
				if(lista != null){
					res = new RespuestaCtrl(false, 1, lista);
				}else{
					res = new RespuestaCtrl(true, 0, "No se encontro ningún Articulo");
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

    @PostMapping(region+"/guardarArticulo")
	public ResponseEntity<RespuestaCtrl> guardarArticulo(@RequestBody List<Articulo> art) {
		RespuestaCtrl res;

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.buildAndExpand()
			.toUri();

		if(art != null && art.size() > 0){
			try{
				if(service.guardarArticulo(art)){
					res = new RespuestaCtrl(false, 1, "Articulo guardado con éxito");
				}else{
					res = new RespuestaCtrl(true, 0, "No se pudo guardar este Articulo");
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

	@PostMapping(region+"/borrarArticulo")
	public ResponseEntity<RespuestaCtrl> borrarArticulo(@RequestBody Articulo art) {
		RespuestaCtrl res;

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.buildAndExpand()
			.toUri();

		if(art != null && art.getSku() != null){
			try{
				if(service.borrarArticulo(""+art.getSku())){
					res = new RespuestaCtrl(false, 1, "Articulo borrado con éxito");
				}else{
					res = new RespuestaCtrl(true, 0, "No se pudo borrar o no se encontró este Articulo");
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

	@PostMapping(region+"/actualizarArticulo")
	public ResponseEntity<RespuestaCtrl> actualizarArticulo(@RequestBody Articulo art) {
		RespuestaCtrl res;

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.buildAndExpand()
			.toUri();

		if(art != null && art.getSku() != null){
			try{
				if(service.actualizarArticulo(art)){
					res = new RespuestaCtrl(false, 1, "Articulo actualizado con éxito");
				}else{
					res = new RespuestaCtrl(true, 0, "No se pudo actualizar o no se encontró este Articulo");
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
