package com.oriontek.cliente_direcciones.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oriontek.cliente_direcciones.dto.DireccionDTO;
import com.oriontek.cliente_direcciones.mapper.DireccionMapper;
import com.oriontek.cliente_direcciones.model.Direccion;
import com.oriontek.cliente_direcciones.repository.DireccionRepository;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    @Autowired
    private DireccionRepository direccionRepository;

    @GetMapping("/{id}")
    public DireccionDTO obtenerDireccionPorId(@PathVariable Long id) {
        Direccion direccion = direccionRepository.findById(id).orElseThrow();
        return DireccionMapper.toDTO(direccion);
    }

    @GetMapping
    public List<DireccionDTO> obtenerDirecciones() {
        return direccionRepository.findAll().stream()
            .map(DireccionMapper::toDTO)
            .collect(Collectors.toList());
    }

    @PostMapping
    public DireccionDTO crearDireccion(@RequestBody DireccionDTO direccionDTO) {
        Direccion direccion = DireccionMapper.toEntity(direccionDTO);
        Direccion direccionGuardada = direccionRepository.save(direccion);
        return DireccionMapper.toDTO(direccionGuardada);
    }

    @PutMapping("/{id}")
    public DireccionDTO actualizarDireccion(@PathVariable Long id, @RequestBody DireccionDTO direccionDTO) {
        Direccion direccion = direccionRepository.findById(id).orElseThrow();
        direccion.setDireccion(direccionDTO.getDireccion());
        direccion.setCodigoPostal(direccionDTO.getCodigoPostal());
        direccion.setProvincia(direccionDTO.getProvincia());
        direccion.setPais(direccionDTO.getPais());

        Direccion direccionActualizada = direccionRepository.save(direccion);
        return DireccionMapper.toDTO(direccionActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarDireccion(@PathVariable Long id) {
        direccionRepository.deleteById(id);
    }
}