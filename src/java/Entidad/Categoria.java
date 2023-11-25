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
public class Categoria {
    
    private String nombre;
    private int categoriaID;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public Categoria(String nombre, int categoriaID) {
        this.nombre = nombre;
        this.categoriaID = categoriaID;
    }
    
}
