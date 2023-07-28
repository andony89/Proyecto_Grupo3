package com.Proyecto_web.Proyecto.dao;


import com.Proyecto_web.Proyecto.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {

}
