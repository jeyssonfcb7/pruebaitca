package controlador;


import java.io.IOException;
import java.util.ArrayList;
import javabeans.Computadora;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import modelo.*;

public class ControladorPC extends HttpServlet {
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


//      HttpSession ses = request.getSession(true);
//      ses.setAttribute("nombre", "10");
//      String x = (String)ses.getAttribute("nombre");
//      ses.getId();
//      ses.setMaxInactiveInterval(100);
//      ses.invalidate();
//      ses.isNew();
//      ses.getLastAccessedTime();
//



    String op=request.getParameter("operacion");
    if(op.equals("envio"))
      response.sendRedirect("pc/agregar.jsp");
    if(op.equals("grabar")){
      Computadora con=(Computadora)request.getAttribute("pc");
      //ses.setAttribute("contacto", con);
      OperacionesPC oper=new OperacionesPC(this.ds);
      oper.insertaCompu(con);
      response.sendRedirect("../index.html");
    }
    if(op.equals("envioModifica"))
        response.sendRedirect("pc/modificar.jsp");
    if(op.equals("modifica")){
        Computadora c = (Computadora)request.getAttribute("pcm");
        OperacionesPC opera = new OperacionesPC(this.ds);
        opera.modificaCompu(c);
        response.sendRedirect("../index.html");
    }
    if(op.equals("envioElimina"))
        response.sendRedirect("pc/eliminar.jsp");
    if(op.equals("elimina")){
        Computadora c = (Computadora)request.getAttribute("pce");
        OperacionesPC opera = new OperacionesPC(this.ds);
        opera.eliminaCompu(c);
        response.sendRedirect("../index.html");
    }
    if(op.equals("ver")){
      OperacionesPC oper=new OperacionesPC(this.ds);
      UtilidadesHTML utilHtml = new UtilidadesHTML();
      ArrayList contactos=oper.obtenerCompu();
      String tablaHtml = utilHtml.generarTablaHtml(contactos);
      request.setAttribute("pcs",tablaHtml);
      RequestDispatcher rd=request.getRequestDispatcher("/tablaPC.jsp");
      rd.forward(request,response);
    }
  }
}