/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;

import Entidad.Articulos;
import Entidad.Categoria;
import Entidad.Proveedor;
import Utilidades.ConexionDB;

/**
 * 
 * @author _mrodriguezb
 */
public class ArticulosDAO {

	public void eliminar(Articulos articulo) {

		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("delete from  Articulos  where idArticulo=?");
			psta.setString(1, articulo.getIdArticulo());

			psta.executeUpdate();
			psta.close();
			cnx.close();

		} catch (Exception e) {
		}

	}

	public void actualizar(Articulos articulo) {

		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("update  Articulos set desArticulo =?,precioArticulo =?,idProveedor =?,idCategoria =?,stockArticulo =?,FechaArticulo ='"
							+ new SimpleDateFormat("yyyy/MM/dd")
									.format(new java.util.Date())
							+ "',Activo =? where idArticulo =? ");
			psta.setString(1, articulo.getDesArticulo());
			psta.setDouble(2, articulo.getPrecioArticulo());
			psta.setInt(3, articulo.getIdProveedor());
			psta.setInt(4, articulo.getIdCategoria());
			psta.setInt(5, articulo.getStockArticulo());
			psta.setInt(6, articulo.getActivo());
			psta.setString(7, articulo.getIdArticulo());
			psta.executeUpdate();

			psta.close();
			cnx.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void insertar(Articulos articulo) {

		try {
			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("insert into  Articulos(desArticulo,precioArticulo,idProveedor,idCategoria,stockArticulo,FechaArticulo,Activo) values(?,?,?,?,?,'"
							+ new SimpleDateFormat("yyyy/MM/dd")
									.format(new java.util.Date()) + "',?)");
			psta.setString(1, articulo.getDesArticulo());
			psta.setDouble(2, articulo.getPrecioArticulo());
			psta.setInt(3, articulo.getIdProveedor());
			psta.setInt(4, articulo.getIdCategoria());
			psta.setInt(5, articulo.getStockArticulo());
			psta.setInt(6, articulo.getActivo());
			//psta.setString(7, articulo.getIdArticulo());getIdArticulo
			psta.executeUpdate();

			psta.close();
			cnx.close();
		} catch (Exception e) {
		}

	}

	public ArrayList<Articulos> listarArticulo() {

		ArrayList<Articulos> lista = new ArrayList<Articulos>();
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from Articulos");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				Articulos em = new Articulos(rs.getString(1), rs.getString(2),
						rs.getDouble(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getInt(8));
				lista.add(em);
			}

			psta.close();
			cnx.close();
		} catch (Exception e) {

			System.out.println("" + e.toString());
		}

		return lista;
	}

	public Articulos buscarArticulo(String codigo) {

		Articulos bean = null;
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from Articulos where idArticulo='"
							+ codigo + "'");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				bean = new Articulos(rs.getString(1), rs.getString(2),
						rs.getDouble(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getInt(8));
			}
			rs.close();
			psta.close();
			cnx.close();
		} catch (Exception e) {

			System.out.println("" + e.toString());
		}

		return bean;
	}

	public String buscarCodigoArticulo() {

		String codigo = "P00001";
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select MAX(idArticulo) as valor from Articulos");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).substring(1)!= null) {
					codigo = "P";
					int valor = Integer.parseInt(rs.getString(1).substring(1)) + 1;
					Formatter fmt = new Formatter();
					codigo += fmt.format("%05d", valor);
				}
					
			}
			rs.close();
			psta.close();
			cnx.close();
		} catch (Exception e) {

			System.out.println("" + e.toString());
		}

		return codigo;
	}

	public ArrayList<Categoria> listarCategoria() {

		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		lista.add(new Categoria("Electrodomesticos", 1));
		lista.add(new Categoria("Abarrotes", 2));
		lista.add(new Categoria("Ropa", 3));
		lista.add(new Categoria("Medicina", 4));

		return lista;
	}

	public ArrayList<Proveedor> listarProveedor() {

		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		lista.add(new Proveedor("Agencias Way", 1));
		lista.add(new Proveedor("Tecno Facil", 2));
		lista.add(new Proveedor("Shein", 3));
		return lista;
	}

}
