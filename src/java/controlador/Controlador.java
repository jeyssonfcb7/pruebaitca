/*
 * Controlador.java
 *
 * Created on 22 de enero de 2008, 15:52
 */

package controlador;




import java.io.*;
import java.sql.Connection;
import java.util.*;
import javabeans.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;
import modelo.*;

public class Controlador extends HttpServlet {
  String url;
  DataSource ds = null;

  public void init(ServletConfig scfig){
    this.url = scfig.getInitParameter("url");
      try {
          Context ctx = new InitialContext();
          ds = (DataSource) ctx.lookup("jdbc/dsItcaFavoritos");
      } catch (Exception e) {
      }
  }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


      HttpSession ses = request.getSession(true);
      ses.setAttribute("nombre", "10");
      String x = (String)ses.getAttribute("nombre");
      /*ses.getId();
      ses.setMaxInactiveInterval(100);
      ses.invalidate();
      ses.isNew();
      ses.getLastAccessedTime();*/




    String op=request.getParameter("operacion");
    if(op.equals("envio"))
      response.sendRedirect("envio.jsp");
    if(op.equals("grabar")){
      Contacto con=(Contacto)request.getAttribute("contac");
      //ses.setAttribute("contacto", con);
      Operaciones oper=new Operaciones(this.ds);
      oper.grabaContacto(con);
      response.sendRedirect("inicio.htm");
    }
    if(op.equals("envioModifica"))
        response.sendRedirect("envioModifica.jsp");
    if(op.equals("modifica")){
        Contacto c = (Contacto)request.getAttribute("contacto");
        Operaciones opera = new Operaciones(this.ds);
        opera.modificaContacto(c);
        response.sendRedirect("inicio.htm");
    }
    if(op.equals("envioElimina"))
        response.sendRedirect("envioElimina.jsp");
    if(op.equals("elimina")){
        Contacto c = (Contacto)request.getAttribute("contacto");
        Operaciones opera = new Operaciones(this.ds);
        opera.eliminaContacto(c);
        response.sendRedirect("inicio.htm");
    }
    if(op.equals("ver")){
      Operaciones oper=new Operaciones(this.ds);
      UtilidadesHTML utilHtml = new UtilidadesHTML();
      ArrayList contactos=oper.obtenerContactos();
      String tablaHtml = utilHtml.generarTablaHtmlContactos(contactos);
      //request.setAttribute("contactos",contactos);
      request.setAttribute("contactos",tablaHtml);
      RequestDispatcher rd=request.getRequestDispatcher("/ver_1.jsp");
      rd.forward(request,response);
    }
  }
}