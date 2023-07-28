package com.Proyecto_web.Proyecto.service.impl;


import com.Proyecto_web.Proyecto.dao.VehiculoDao;
import com.Proyecto_web.Proyecto.domain.Vehiculo;
import com.Proyecto_web.Proyecto.service.VehiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoDao vehiculoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> getVehiculos(boolean activos) {
        var lista = vehiculoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Vehiculo getVehiculo(Vehiculo vehiculo) {
        return vehiculoDao.findById(vehiculo.getIdVehiculo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Vehiculo vehiculo) {
        vehiculoDao.save(vehiculo);
    }

    @Override
    @Transactional
    public void delete(Vehiculo vehiculo) {
        vehiculoDao.delete(vehiculo);
    }

    //Lista de vehiculos con precio entre ordenados por descripcion ConsultaAmpliada
    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {
        return vehiculoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> metodoJPQL(double precioInf, double precioSup) {
        return vehiculoDao.metodoJPQL(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> metodoNativo(double precioInf, double precioSup) {
        return vehiculoDao.metodoNativo(precioInf, precioSup);
    }

}
