/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author _mrodriguezb
 */
public class Proveedor {

    private String provedor;
    private int proveedorID;

    public Proveedor(String provedor, int proveedorID) {
        this.provedor = provedor;
        this.proveedorID = proveedorID;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

    public int getProveedorID() {
        return proveedorID;
    }

    public void setProveedorID(int proveedorID) {
        this.proveedorID = proveedorID;
    }

}
