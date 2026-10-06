package com.techlab.articulo.model;

public class Articulo {
    private int codigo;
    private String nombre;
    private double precio;
    private Categoria categoria;

    public Articulo(int codigo, String nombre, double precio, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Métodos normales en lugar de abstractos para ser sobreescritos por las hijas
    public String getTipoArticulo() {
        return "General";
    }

    protected String getDetalleEspecifico() {
        return "sin detalles específicos";
    }

    @Override
    public String toString() {
        return "Articulo [Tipo=" + getTipoArticulo() +
                ", codigo=" + codigo +
                ", nombre=" + nombre +
                ", precio=$" + precio +
                ", categoria=" + (categoria != null ? categoria.getNombre() : "Sin categoria") +
                ", " + getDetalleEspecifico() + "]";
    }
}