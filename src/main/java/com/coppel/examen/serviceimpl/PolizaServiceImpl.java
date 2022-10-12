package com.coppel.examen.serviceimpl;

import java.util.List;

import com.coppel.examen.model.Polizas;
import com.coppel.examen.repository.PolizaRepository;
import com.coppel.examen.service.PolizaService;

public class PolizaServiceImpl implements PolizaService{
    PolizaRepository repository = new PolizaRepository();

    @Override
    public boolean guardarPoliza(Polizas pol) throws Exception {
        return repository.guardarPoliza(pol);
    }

    @Override
    public List<Polizas> buscarPolizas(String id) throws Exception {
        return repository.buscarPolizas(id);
    }

    @Override
    public boolean borrarPoliza(String id) throws Exception {
        return repository.borrarPoliza(id);
    }

    @Override
    public boolean actualizarPoliza(Polizas pol) throws Exception {
        return repository.actualizarPoliza(pol);
    }
    
}
