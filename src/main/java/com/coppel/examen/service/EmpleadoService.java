package com.coppel.examen.service;

import java.util.List;

import com.coppel.examen.model.Empleado;

public interface EmpleadoService {
    
    public boolean guardarEmpleado(Empleado emp) throws Exception;
    public List<Empleado> buscarEmpleados(String id) throws Exception;
    public boolean borrarEmpleado(String id) throws Exception;
    public boolean actualizarEmpleado(Empleado emp) throws Exception;
}
