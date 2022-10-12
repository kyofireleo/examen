package com.coppel.examen.service;

import java.util.List;

import com.coppel.examen.model.Polizas;

public interface PolizaService {
    
    public boolean guardarPoliza(Polizas art) throws Exception;
    public List<Polizas> buscarPolizas(String id) throws Exception;
    public boolean borrarPoliza(String id) throws Exception;
    public boolean actualizarPoliza(Polizas art) throws Exception;
}
