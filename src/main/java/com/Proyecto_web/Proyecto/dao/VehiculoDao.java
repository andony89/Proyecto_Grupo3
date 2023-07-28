package com.Proyecto_web.Proyecto.dao;



import com.Proyecto_web.Proyecto.domain.Vehiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VehiculoDao extends JpaRepository<Vehiculo, Long> {
    //Ejemplo de método utilizando Métodos de Query
    public List<Vehiculo> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    //Ejemplo de método utilizando Consultas con JPQL
    @Query(value = "SELECT a FROM Vehiculo a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Vehiculo> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery = true,
            value = "SELECT * FROM vehiculo where vehiculo.precio BETWEEN :precioInf AND :precioSup ORDER BY vehiculo.descripcion ASC")
    public List<Vehiculo> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
}
