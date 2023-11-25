 <%@page import="Entidad.Articulos"%>
<%@page import="DAO.ArticulosDAO"%>
<%
            
 ArticulosDAO obj=new ArticulosDAO();
            	Articulos beanArticulo = new Articulos();
            	  String cod = request.getParameter("cod");
            	beanArticulo.setIdArticulo(cod);
                obj.eliminar(beanArticulo);
                request.getRequestDispatcher("index.jsp").forward(request, response);

        %>