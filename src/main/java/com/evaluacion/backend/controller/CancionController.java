package com.evaluacion.backend.controller;

import com.evaluacion.backend.service.ICancionService;
import com.evaluacion.backend.model.Cancion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author b44rto
 */
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/cancion")
public class CancionController {

    @Autowired
    ICancionService cancionService;

    @GetMapping("/listar")
    public ResponseEntity< List<Cancion>> listarCanciones() {
        return new ResponseEntity<>(cancionService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Cancion> crearCancion(@RequestBody Cancion cancion) {
        return new ResponseEntity<>(cancionService.save(cancion), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Cancion> eliminarCancion(@PathVariable Integer id) {
        cancionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cancion> actualizarCancion(@PathVariable Integer id, @RequestBody Cancion cc) {
        Cancion cancion = cancionService.findById(id);
        if (cancion == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                cancion.setTitle(cc.getTitle());
                cancion.setArtist(cc.getArtist());
                cancion.setAlbum(cc.getAlbum());
                cancion.setYear(cc.getYear());
                return new ResponseEntity<>(cancionService.save(cancion), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
