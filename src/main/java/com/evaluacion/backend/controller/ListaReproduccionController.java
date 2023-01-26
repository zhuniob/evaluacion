package com.evaluacion.backend.controller;

import com.evaluacion.backend.model.ListaReproduccion;
import com.evaluacion.backend.service.IListaReproduccionService;
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
@RequestMapping("/lista_reproduccion")
public class ListaReproduccionController {

    @Autowired
    IListaReproduccionService listaService;

    @GetMapping("/listar")
    public ResponseEntity< List<ListaReproduccion>> listarCanciones() {
        return new ResponseEntity<>(listaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ListaReproduccion> crearCancion(@RequestBody ListaReproduccion lista) {
        return new ResponseEntity<>(listaService.save(lista), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ListaReproduccion> eliminarCancion(@PathVariable Integer id) {
        listaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ListaReproduccion> actualizarCancion(@PathVariable Integer id, @RequestBody ListaReproduccion ll) {
        ListaReproduccion lista = listaService.findById(id);
        if (lista == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                lista.setName(ll.getName());
                lista.setDescription(ll.getDescription());
                lista.setSongs(ll.getSongs());
                return new ResponseEntity<>(listaService.save(lista), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
