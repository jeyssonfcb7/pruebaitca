<%--
    Document   : agregar
    Created on : 12-16-2017, 11:27:25 AM
    Author     : Gerardo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Modificar Sitio Web</title>
	</head>
<jsp:useBean id="webm" scope="request" class="javabeans.Web" />
<jsp:setProperty name="webm" property="*"/>
<%if(request.getParameter("direccion_website")!=null && request.getParameter("direccion_website")!=""){%>
   <jsp:forward page="../controladorweb?operacion=modifica"/>
<%}%>
<body>
<div>
  <h1>Modificar Sitio Web</h1>
  <form method="post">
  <br/><br/>
  <b>Datos para el sitio web</b><br/><br/>
  Introduzca Id:  <input type="text" name="id"><br/>
  <br/>
  Direcci&oacute;n:  <input type="text" name="direccion_website"><br/>
  <br/>
  WebSite: <input type="text" name="nombre_website"><br/>
  <br/>
  Categor&iacute;a: <input type="text" name="categoria"><br/>
  <br/>
  SubCategor&iacute;a: <textarea name="subcategoria"></textarea><br/>
  <br/>
  Puntuacion:  <input type="text" name="puntuacion"><br/>
  <br/>
  Idioma:  <input type="text" name="idioma"><hr/><br/>
  <br/>
  Fecha Insercion:  <input type="text" name="fecha_insercion"><hr/><br/>
  <br/>

  <input type="submit" name="Submit" value="Guardar">
  <input type="reset" value="Reset">
  </form>
</div>
</body>
</html>
