package com.oriontek.cliente_direcciones.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;
    @NotNull(message = "La dirección no puede ser nula")
    private String codigoPostal;

    private String provincia;

    private String pais;

    private LocalDateTime ultimaActualizacion;

    // Relacion con cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference               // evitar bucle infinito en serializacion
    @NotNull(message = "El cliente no puede ser nulo")
    // @NotNull(message = "El cliente no puede ser nulo")   
    private Cliente cliente;

    // get y set
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }

    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    //    public LocalDate getUltimaActualizacion() { return ultimaActualizacion; }
    public LocalDateTime getUltimaActualizacion() { return ultimaActualizacion; }
    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) { this.ultimaActualizacion = ultimaActualizacion; }
    public Direccion() {
        this.ultimaActualizacion = LocalDateTime.now();
    }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

}