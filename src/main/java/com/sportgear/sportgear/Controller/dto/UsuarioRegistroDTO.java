package com.sportgear.sportgear.Controller.dto;

public class UsuarioRegistroDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;

    private String rol;
    private Long codigo;
    private Long telefono;
    private String programa;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public UsuarioRegistroDTO(String nombre, String apellido, String email, String password, Long codigo, Long telefono, String programa, String rol) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.codigo = codigo;
        this.telefono = telefono;
        this.programa = programa;
        this.rol = rol;
    }

    public UsuarioRegistroDTO() {

    }
}
