package com.Proyecto_web.Proyecto.service;



import com.Proyecto_web.Proyecto.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    // Se obtiene un listado de categorias en un List
    public List<Categoria> getCategorias(boolean activos);
 
    //Se obtiene una Categoria, a partir del id de una Categoria
    public Categoria getCategoria(Categoria categoria);
    
    //Se inserta una nueva Categoria si el id de la categoria esta vacio
    //se actualiza una categoria si el id de la categoria NO esta vacio
    public void save(Categoria categoria);
    
    //Se elimina la categoria que se tiene el id pasado por parametro
    public void delete(Categoria categoria);
    
}
