package com.TpJPA.GestionPeliculas.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table (name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "El titulo debe ser obligatorio")
    @Column (nullable = false, unique = true)
    private String titulo;

    @NotNull(message = "El anio de estreno es obligatorio")
    @Column (nullable = false)
    private Integer anioEstreno;

    @Min(value = 1,message = "La duracion debe ser mayor a 0 minutos")
    @Max(value = 500,message = "La duracion no debe superar los 500 minutos")
    private Integer duracion;

    @ManyToOne
    @JoinColumn (name = "genero_id", nullable = false)
    private Genero genero;

    @ManyToMany
    @JoinTable (
            name = "pelicula_generos",
            joinColumns = @JoinColumn(name="pelicula_id"),
            inverseJoinColumns = @JoinColumn (name = "genero_id")
    )
    private List<Genero> generosSecundarios;

    @ManyToMany
    @JoinTable(
            name = "pelicula_actor",
            joinColumns = @JoinColumn (name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn (name = "actor_id")
    )
    private List <Actor> actores;

    @ManyToOne
    @JoinColumn (name = "director_id")
    private Director director;

    @OneToMany(mappedBy = "pelicula",cascade =CascadeType.ALL,orphanRemoval = true)
    private List <Resenia> resenias;


    public Pelicula( String titulo, Integer anioEstreno, Integer duracion, Genero genero, List<Genero> generosSecundarios, List<Actor> actores, Director director, List<Resenia> resenias) {
        this.titulo = titulo;
        this.anioEstreno = anioEstreno;
        this.duracion = duracion;
        this.genero = genero;
        this.generosSecundarios = generosSecundarios;
        this.actores = actores;
        this.director = director;
        this.resenias = resenias;
    }

    /// getters y setters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(Integer anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Genero> getGenerosSecundarios() {
        return generosSecundarios;
    }

    public void setGenerosSecundarios(List<Genero> generosSecundarios) {
        this.generosSecundarios = generosSecundarios;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Resenia> getResenias() {
        return resenias;
    }

    public void setResenias(List<Resenia> resenias) {
        this.resenias = resenias;
    }
}
