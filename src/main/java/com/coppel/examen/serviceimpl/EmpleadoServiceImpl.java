package com.coppel.examen.serviceimpl;

import java.util.List;

import com.coppel.examen.model.Empleado;
import com.coppel.examen.repository.EmpleadoRepository;
import com.coppel.examen.service.EmpleadoService;

public class EmpleadoServiceImpl implements EmpleadoService{
    private EmpleadoRepository empleadoRepository = new EmpleadoRepository();

    @Override
    public boolean guardarEmpleado(Empleado emp) throws Exception {
        return empleadoRepository.guardarEmpleado(emp);
    }

    @Override
    public List<Empleado> buscarEmpleados(String id) throws Exception {
        return empleadoRepository.buscarEmpleados(id);
    }

    @Override
    public boolean borrarEmpleado(String id) throws Exception {
        return empleadoRepository.borrarEmpleado(id);
    }

    @Override
    public boolean actualizarEmpleado(Empleado emp) throws Exception {
        return empleadoRepository.actualizarEmpleado(emp);
    }
    
}
