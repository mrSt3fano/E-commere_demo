package com.sistema.regisstro.Sistemademo.DTO;

public class WebSupplier {

    private String nombre;

    private String compania;

    private String direccion;

    private String ciudad;

    private String numeroTelefonico;

    private String tipoDeproducto;

    private Integer numraro;

    public WebSupplier() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getTipoDeproducto() {return tipoDeproducto; }

    public void setTipoDeproducto(String tipoDeproducto) { this.tipoDeproducto = tipoDeproducto; }

    public Integer getNumraro() {
        return numraro;
    }

    public void setNumraro(Integer numraro) {
        this.numraro = numraro;
    }
}
