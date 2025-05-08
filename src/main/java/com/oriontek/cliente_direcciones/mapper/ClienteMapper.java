package com.oriontek.cliente_direcciones.mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.oriontek.cliente_direcciones.dto.ClienteDTO;
import com.oriontek.cliente_direcciones.dto.DireccionDTO;
import com.oriontek.cliente_direcciones.model.Cliente;
import com.oriontek.cliente_direcciones.model.Direccion;

public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente cliente) {
        List<DireccionDTO> direccionesDTO = cliente.getDirecciones().stream()
            .map(direccion -> new DireccionDTO(
                direccion.getId(), 
                direccion.getDireccion(),
                direccion.getCodigoPostal(),
                direccion.getProvincia(),
                direccion.getPais(),
                direccion.getUltimaActualizacion() != null ? direccion.getUltimaActualizacion().toString() : null,  // 🔹 Convertimos `LocalDateTime` a `String`, evitando `null`
                direccion.getCliente() != null ? direccion.getCliente().getId() : null)) // 🔹 Evitamos error de `null`
            .collect(Collectors.toList());

        return new ClienteDTO(
            cliente.getId(),
            cliente.getNombre(),
            cliente.getEmail(),
            direccionesDTO,
            cliente.getTelefono(),
            cliente.getFechaRegistro().toString(), 
            cliente.getFechaNacimiento().toString()
        );
    }

    public static Cliente toEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());  
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());

        
        cliente.setFechaRegistro(LocalDate.parse(dto.getFechaRegistro()).atStartOfDay());
        cliente.setFechaNacimiento(LocalDate.parse(dto.getFechaNacimiento()));

        List<Direccion> direcciones = dto.getDirecciones().stream()
            .map(direccionDTO -> {
                Direccion direccion = new Direccion();
                direccion.setDireccion(direccionDTO.getDireccion());
                direccion.setCodigoPostal(direccionDTO.getCodigoPostal());
                direccion.setProvincia(direccionDTO.getProvincia());
                direccion.setPais(direccionDTO.getPais());
                return direccion;
            })
            .collect(Collectors.toList());

        cliente.setDirecciones(direcciones);
        return cliente;
    }
}