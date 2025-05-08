package com.oriontek.cliente_direcciones.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

import com.oriontek.cliente_direcciones.dto.ClienteDTO;
import com.oriontek.cliente_direcciones.mapper.ClienteMapper;
import com.oriontek.cliente_direcciones.model.Cliente;
import com.oriontek.cliente_direcciones.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/{id}")
    public ClienteDTO obtenerClientePorId(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        return ClienteMapper.toDTO(cliente);
    }

    @GetMapping
    public List<ClienteDTO> obtenerClientes() {
        return clienteRepository.findAll().stream()
            .map(ClienteMapper::toDTO)
            .collect(Collectors.toList());
    }

    @PostMapping
    public ClienteDTO crearCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = ClienteMapper.toEntity(clienteDTO);
        Cliente clienteGuardado = clienteRepository.save(cliente);
        return ClienteMapper.toDTO(clienteGuardado);
    }

    @PutMapping("/{id}")
    public ClienteDTO actualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setFechaRegistro(LocalDateTime.parse(clienteDTO.getFechaRegistro()));
        cliente.setFechaNacimiento(LocalDate.parse(clienteDTO.getFechaNacimiento()));

        Cliente clienteActualizado = clienteRepository.save(cliente);
        return ClienteMapper.toDTO(clienteActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
}