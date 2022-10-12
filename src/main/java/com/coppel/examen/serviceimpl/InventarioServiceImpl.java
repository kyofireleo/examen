package com.coppel.examen.serviceimpl;

import java.util.List;

import com.coppel.examen.model.Articulo;
import com.coppel.examen.repository.InventarioRepository;
import com.coppel.examen.service.InventarioService;

public class InventarioServiceImpl implements InventarioService{
    private InventarioRepository repository = new InventarioRepository();

    @Override
    public boolean guardarArticulo(List<Articulo> art) throws Exception {
        return repository.guardarArticulo(art);
    }

    @Override
    public List<Articulo> buscarArticulos(String id) throws Exception {
        return repository.buscarArticulos(id);
    }

    @Override
    public boolean borrarArticulo(String id) throws Exception {
        return repository.borrarArticulo(id);
    }

    @Override
    public boolean actualizarArticulo(Articulo art) throws Exception {
        return repository.actualizarArticulo(art);
    }
    
}
