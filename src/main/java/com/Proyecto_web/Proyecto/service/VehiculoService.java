package com.Proyecto_web.Proyecto.service;



import com.Proyecto_web.Proyecto.domain.Vehiculo;
import java.util.List;

public interface VehiculoService {

    public List<Vehiculo> getVehiculos(boolean activos);

    public Vehiculo getVehiculo(Vehiculo vehiculo);

    public void save(Vehiculo vehiculo);

    public void delete(Vehiculo vehiculo);
    
    //Lista de vehiculos por precio ordenada por descripcion consultaAmpliada
    public List<Vehiculo> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
    //Lista de vehiculos usando consultas JPQL
    public List<Vehiculo> metodoJPQL(double precioInf, double precioSup);
    
    //Lista de vehiculos utilizando consultas SQL Nativo
    public List<Vehiculo> metodoNativo(double precioInf, double precioSup);
}
