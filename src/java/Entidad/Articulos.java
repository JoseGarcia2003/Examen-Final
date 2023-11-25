/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.Date;

/**
 *
 * @author _mrodriguezb
 */
public class Articulos {

    private String idArticulo;
    private String desArticulo;
    private double precioArticulo;
    private int idProveedor;
    private int idCategoria;
    private int stockArticulo;
    private String FechaArticulo;
    private int Activo;

    public Articulos(){
    	
    }
    public Articulos(String idArticulo, String desArticulo, double precioArticulo, int idProveedor, int idCategoria, int stockArticulo, String FechaArticulo, int Activo) {
        this.idArticulo = idArticulo;
        this.desArticulo = desArticulo;
        this.precioArticulo = precioArticulo;
        this.idProveedor = idProveedor;
        this.idCategoria = idCategoria;
        this.stockArticulo = stockArticulo;
        this.FechaArticulo = FechaArticulo;
        this.Activo = Activo;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDesArticulo() {
        return desArticulo;
    }

    public void setDesArticulo(String desArticulo) {
        this.desArticulo = desArticulo;
    }

    public double getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(double precioArticulo) {
        this.precioArticulo = precioArticulo;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getStockArticulo() {
        return stockArticulo;
    }

    public void setStockArticulo(int stockArticulo) {
        this.stockArticulo = stockArticulo;
    }

    public String getFechaArticulo() {
        return FechaArticulo;
    }

    public void setFechaArticulo(String FechaArticulo) {
        this.FechaArticulo = FechaArticulo;
    }

    public int getActivo() {
        return Activo;
    }

    public void setActivo(int Activo) {
        this.Activo = Activo;
    }

}
