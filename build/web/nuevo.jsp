<%@page import="Entidad.Articulos"%>
<%@page import="Entidad.Categoria"%>
<%@page import="Entidad.Proveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.ArticulosDAO"%>
<!DOCTYPE html>
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>JSP Page</title>
 
 </head>
 <body>
  <%
           
        ArticulosDAO obj=new ArticulosDAO();
  String codigoArticulo = obj.buscarCodigoArticulo();
        %>
 <h2 align="center">Nuevos Articulo</h2>
 
   <form action="nuevo.jsp">
            <table border="1" width="90%" align="center">
               
                <tr>
                    <td>Descripcion: </td>
                    <td><input type="text" name="txtDescripcion" ></td>
                </tr><tr>
                    <td>Precio: </td>
                    <td><input type="text" name="txtPrecio"></td>
                </tr>
                <tr>
                    <td>Provedor: </td>
                    <td>
                    <select name="cboProveedor">
                    <option value="-1">Seleccione</option>
                    <%
                    for(Proveedor proveedor:obj.listarProveedor()){
                    %>
                    <option value="<%=proveedor.getProveedorID()%>"><%=proveedor.getProvedor()%></option>	
                    	<%
                    }
                    %>
                    </select>
                    </td>
                </tr>
                
                <tr>
                    <td>Categoria: </td>
                    <td>
                    <select name="cboCategoria">
                    <option value="-1">Seleccione</option>
                    <%
                    for(Categoria categoria:obj.listarCategoria()){
                    	%>
                    <option value="<%=categoria.getCategoriaID()%>" ><%=categoria.getNombre()%></option>	
                    	<%
                    }
                    %>
                    </select>
                    </td>
                </tr>
                
                <tr>
                    <td>Stock: </td>
                    <td><input type="text" name="txtStock" ></td>
                </tr>
                
                 <tr>
                    <td>Fecha: </td>
                    <td><input type="text" name="txtFecha" ></td>
                </tr>
                
                 <tr>
                    <td>Estado: </td>
                    <td>
                    <input type="radio" name="rdnestado" value="0" checked="checked" >Inactivo</input>
                    <input type="radio" name="rdnestado" value="1" >Activo</input>
                    </td>
                </tr>
                <tr>
                    <th colspan="2">
                    <input type="hidden" name="accion" />
                    <input type="button" name="btn"
                                           value="Nuevo Datos" onclick="enviarDatos();"></th>
                </tr>
            </table>
        </form>
        
        <script type="text/javascript">
        
        function enviarDatos(){
        	if(document.forms[0].txtDescripcion.value.length==0){
        		alert("Ingrese Desacripcion");
            	return;	
        	}
        	if(document.forms[0].txtPrecio.value.length==0){
        		alert("Ingrese Precio");
            	return;	
        	}
        	if(document.forms[0].cboProveedor.value=="-1"){
        		alert("Seleccion Proveedor");
            	return;	
        	}
        	if(document.forms[0].cboCategoria.value=="-1"){
        		alert("Seleccion Categoria");
            	return;	
        	}
        	
        	if(document.forms[0].txtStock.value.length==0){
        		alert("Ingrese Stock");
            	return;	
        	}
        	
        	if(document.forms[0].txtFecha.value.length==0){
        		alert("Ingrese Fecha dd/MM/yyyy");
            	return;	
        	}
        	document.forms[0].accion.value="nuevo";
        	document.forms[0].submit();
        }
        </script>
 <%
  if(request.getParameter("accion")!=null && request.getParameter("accion").equals("nuevo")){
	  Articulos beanArticulo = new Articulos();
  	beanArticulo.setIdArticulo(request.getParameter("cod"));
  	beanArticulo.setDesArticulo(request.getParameter("txtDescripcion"));
  	beanArticulo.setPrecioArticulo(Double.parseDouble(request.getParameter("txtPrecio")));
  	beanArticulo.setIdProveedor(Integer.parseInt(request.getParameter("cboProveedor")));
  	beanArticulo.setIdCategoria(Integer.parseInt(request.getParameter("cboCategoria")));
  	beanArticulo.setStockArticulo(Integer.parseInt(request.getParameter("txtStock")));
  	beanArticulo.setFechaArticulo(request.getParameter("txtFecha"));
  	beanArticulo.setActivo(Integer.parseInt(request.getParameter("rdnestado")));
      obj.insertar(beanArticulo);
      request.getRequestDispatcher("index.jsp").forward(request, response);
 request.getRequestDispatcher("index.jsp").forward(request, response);
 }
 %>
 <h3 align="center">
 <a href="index.jsp">Volver a Principal</a>
 </h3>
 </body>
</html>