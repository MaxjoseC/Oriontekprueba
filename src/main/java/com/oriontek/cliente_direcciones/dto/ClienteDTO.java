package com.oriontek.cliente_direcciones.dto;
import java.util.List;

public class ClienteDTO {
    private Long id;
    private String nombre;
    private String email;
    private List<DireccionDTO> direcciones;
    private String telefono;
    private String fechaRegistro;	
    private String fechaNacimiento;

    
    public ClienteDTO(Long id, String nombre, String email, List<DireccionDTO> direcciones, String telefono,
            String fechaRegistro, String fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.direcciones = direcciones;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
        this.fechaNacimiento = fechaNacimiento;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<DireccionDTO> getDirecciones() {
        return direcciones;
    }
    public void setDirecciones(List<DireccionDTO> direcciones) {
        this.direcciones = direcciones;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
