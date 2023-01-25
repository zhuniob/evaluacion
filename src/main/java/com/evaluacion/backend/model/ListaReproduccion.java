package com.evaluacion.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author b44rto
 */
@Entity
@Getter
@Setter
public class ListaReproduccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista")
    private Integer id_lista;

    private String name;

    private String description;

    private String songs;

    /* 
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "lista_cancion",
            joinColumns = {
                @JoinColumn(name = "id_lista")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_cancion")})
    private List<Cancion> canciones = new ArrayList<Cancion>();
     */
    @ManyToMany
    @JoinTable(name = "listadecanciones", joinColumns = @JoinColumn(name = "id_lista"),
            inverseJoinColumns = @JoinColumn(name = "id_cancion"))
    private List<ListaReproduccion> canciones = new ArrayList<>();

}
