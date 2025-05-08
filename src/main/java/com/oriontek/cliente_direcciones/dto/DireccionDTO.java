package com.oriontek.cliente_direcciones.dto;

public class DireccionDTO {
    private Long id;
    private String direccion;
    private String codigoPostal;
    private String provincia;
    private String pais;
    private String ultimaActualizacion;
    private Long clienteId;

    public DireccionDTO() {}


    public DireccionDTO(Long id, String direccion, String codigoPostal, String provincia, String pais, String ultimaActualizacion, Long clienteId) {
        this.id = id;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.pais = pais;
        this.ultimaActualizacion = ultimaActualizacion;
        this.clienteId = clienteId;
    }

    // Getters y Setters
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

    public String getUltimaActualizacion() { return ultimaActualizacion; }
    public void setUltimaActualizacion(String ultimaActualizacion) { this.ultimaActualizacion = ultimaActualizacion; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
}