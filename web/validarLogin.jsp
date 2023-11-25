<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="DAO.UsuarioDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Validar Inicio de Sesión</title>
</head>
<body>
    <%
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        if (usuarioDAO.validarUsuario("jgarcia", "1234")) {
                response.sendRedirect("index.jsp");
        } else {
    %>
        <h2>Error de inicio de sesión</h2>
        <p>Usuario y/o contraseña incorrectos. Por favor, inténtalo de nuevo o regístrate.</p>
    <%
        }
    %>
</body>
</html>
