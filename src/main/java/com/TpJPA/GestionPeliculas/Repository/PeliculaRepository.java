package com.TpJPA.GestionPeliculas.Repository;

import com.TpJPA.GestionPeliculas.Model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula,Long> {
}
