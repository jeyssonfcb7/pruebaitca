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

public class ControladorWeb extends HttpServlet {
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
      ses.setAttribute("nombre_website", "10");
      String x = (String)ses.getAttribute("nombre_website");
      /*ses.getId();
      ses.setMaxInactiveInterval(100);
      ses.invalidate();
      ses.isNew();
      ses.getLastAccessedTime();*/



    String op=request.getParameter("operacion");
    if(op.equals("envio"))
      response.sendRedirect("webs/agregar.jsp");
    if(op.equals("grabar")){
      Web con=(Web)request.getAttribute("web");
      //ses.setAttribute("contacto", con);
      OperacionesWeb oper=new OperacionesWeb(this.ds);
      oper.grabaWeb(con);
      response.sendRedirect("../index.html");
    }
    if(op.equals("envioModifica"))
        response.sendRedirect("webs/modificar.jsp");
    if(op.equals("modifica")){
        Web c = (Web)request.getAttribute("webm");
        OperacionesWeb opera = new OperacionesWeb(this.ds);
        opera.modificaWeb(c);
        response.sendRedirect("../index.html");
    }
    if(op.equals("envioElimina"))
        response.sendRedirect("webs/eliminar.jsp");
    if(op.equals("elimina")){
        Web c = (Web)request.getAttribute("webe");
        OperacionesWeb opera = new OperacionesWeb(this.ds);
        opera.eliminaWeb(c);
        response.sendRedirect("../index.html");
    }
    if(op.equals("ver")){
      OperacionesWeb oper=new OperacionesWeb(this.ds);
      UtilidadesHTML utilHtml = new UtilidadesHTML();
      ArrayList webs=oper.obtenerWebs();
      String tablaHtml = utilHtml.generarTablaHtmlWeb(webs);
      //request.setAttribute("contactos",contactos);
      request.setAttribute("webs",tablaHtml);
      RequestDispatcher rd=request.getRequestDispatcher("/tablaWeb.jsp");
      rd.forward(request,response);
    }
  }
}