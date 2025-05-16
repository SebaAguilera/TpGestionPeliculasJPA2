package com.TpJPA.GestionPeliculas.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "resenias")
public class Resenia {

    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message ="El comentario es obligatorio")
    @Column(nullable = false)
    private String comentario;

    @Min(value = 1,message = "La puntuacion debe estar en el rango entre 1 y 5")
    @Max(value = 5,message = "La puntuacion debe estar en el rango entre 1 y 5")
    private Integer puntuacion;

    @ManyToOne
    @JoinColumn (name ="pelicula_id")
    private Pelicula pelicula;

    public Resenia( String comentario, Integer puntuacion, Pelicula pelicula) {
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.pelicula = pelicula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
