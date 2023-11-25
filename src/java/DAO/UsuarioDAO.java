package DAO;

import Utilidades.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    
    public boolean validarUsuario(String usuario, String contrasenia) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resultado = false;
        
        try {
            conn = ConexionDB.getConexion();
            String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasenia = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                // El usuario y contraseña coinciden en la base de datos
                resultado = true;
                 
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return resultado;
    }
}
