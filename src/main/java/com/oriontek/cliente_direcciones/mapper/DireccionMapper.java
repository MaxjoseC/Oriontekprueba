package com.oriontek.cliente_direcciones.mapper;

import java.time.LocalDateTime;

import com.oriontek.cliente_direcciones.dto.DireccionDTO;
import com.oriontek.cliente_direcciones.model.Cliente;
import com.oriontek.cliente_direcciones.model.Direccion;

public class DireccionMapper {

    public static DireccionDTO toDTO(Direccion direccion) {
        return new DireccionDTO(
            direccion.getId(),
            direccion.getDireccion(),
            direccion.getCodigoPostal(),
            direccion.getProvincia(),
            direccion.getPais(),
            direccion.getUltimaActualizacion() != null ? direccion.getUltimaActualizacion().toString() : null,
            direccion.getCliente() != null ? direccion.getCliente().getId() : null // 🔹 Evita `null`
        );
    }

    public static Direccion toEntity(DireccionDTO dto) {
        Direccion direccion = new Direccion();
        direccion.setDireccion(dto.getDireccion());
        direccion.setCodigoPostal(dto.getCodigoPostal());
        direccion.setProvincia(dto.getProvincia());
        direccion.setPais(dto.getPais());

        // 🔹 Convertimos `String` a `LocalDateTime`
        if (dto.getUltimaActualizacion() != null) {
            direccion.setUltimaActualizacion(LocalDateTime.parse(dto.getUltimaActualizacion()));
        }

        // 🔹 Asignamos correctamente el `Cliente`
        if (dto.getClienteId() != null) {
            Cliente cliente = new Cliente();
            cliente.setId(dto.getClienteId());  // ✅ Se asigna el ID del cliente
            direccion.setCliente(cliente);  // 🔹 Vinculamos `Direccion` con el `Cliente`
        }

        return direccion;
    }
}