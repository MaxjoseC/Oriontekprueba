package com.oriontek.cliente_direcciones.controller;

// Controoller para 
//
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.oriontek.cliente_direcciones.model.Direccion;
import com.oriontek.cliente_direcciones.repository.DireccionRepository;

// endpoints para direcciones

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    @Autowired
    private DireccionRepository direccionRepository;

    @PostMapping
    public Direccion crearDireccion(@RequestBody Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    @GetMapping("/{id}")
    public Direccion obtenerDireccion(@PathVariable Long id) {
        return direccionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dirección no encontrada"));
    }

    @GetMapping
    public List<Direccion> listarDirecciones() {
        return direccionRepository.findAll();
    }

    @PutMapping("/{id}")
    public Direccion actualizarDireccion(@PathVariable Long id, @RequestBody Direccion direccionDetalles) {
        Direccion direccion = direccionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dirección no encontrada"));

        direccion.setDireccion(direccionDetalles.getDireccion());
        return direccionRepository.save(direccion);
    }

    @DeleteMapping("/{id}")
    public void eliminarDireccion(@PathVariable Long id) {
        direccionRepository.deleteById(id);
    }
}