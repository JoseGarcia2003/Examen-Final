<%@page import="Entidad.Categoria"%>
<%@page import="Entidad.Proveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidad.Articulos,DAO.ArticulosDAO,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <h2 align="center">LISTADO DE ARTICULO</h2>

        <Table class="table-primary" border="1" width="90%" align="center">
            <tr>
                <th colspan="5">MANTENIMIENTO DE ARTICULOS</th>
                <th><a href="nuevo.jsp">Nuevo</a></th>
            </tr><tr>
                <th>Codigo</th>
                <th>Descripcion</th>
                <th>Precio</th>
                <th>Proveedor</th>
                <th>Categoria</th>
                <th>Stock</th>
                <th>Fecha</th>
                <th>Activo</th>
                <th>Accion</th>
            </tr>
            <%
                ArticulosDAO dao = new ArticulosDAO();
                ArrayList<Articulos> lista = dao.listarArticulo();
                for (Articulos e : lista) {
            %>
            <tr>
                <td><%=e.getIdArticulo()%></td>
                <td><%=e.getDesArticulo()%></td>
                <td><%=e.getPrecioArticulo()%></td>
                <td><% for (Proveedor prove : dao.listarProveedor()) {
                        if (prove.getProveedorID() == e.getIdProveedor()) {
                    %>
                    <%=  prove.getProvedor()%>
                    <% break;
                            }
                        }%>

                </td>
                <td><% for (Categoria cate : dao.listarCategoria()) {
                        if (cate.getCategoriaID()== e.getIdCategoria()) {
                    %>
                    <%=  cate.getNombre()%>
                    <% break;
                            }
                        }%></td>
                <td><%=e.getStockArticulo()%></td>
                <td><%=e.getFechaArticulo()%></td>
                <td><%=(e.getActivo() == 1 ? "Activo" : "Inactivo")%></td>
                <th><a href="eliminar.jsp?cod=<%=e.getIdArticulo()%>">Eliminar</a>
                    || <a href="editar.jsp?cod=<%=e.getIdArticulo()%>">Editar</a></th>
            </tr>
            <%
                }
            %>
        </Table>
         <a href="login.jsp">Salir</a>
    </body>
</html>