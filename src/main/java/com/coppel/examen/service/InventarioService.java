package com.coppel.examen.service;

import java.util.List;

import com.coppel.examen.model.Articulo;

public interface InventarioService {

    public boolean guardarArticulo(List<Articulo> art) throws Exception;
    public List<Articulo> buscarArticulos(String id) throws Exception;
    public boolean borrarArticulo(String id) throws Exception;
    public boolean actualizarArticulo(Articulo art) throws Exception;
}
