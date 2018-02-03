<%--
    Document   : agregar
    Created on : 12-16-2017, 11:27:25 AM
    Author     : Gerardo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Agregar Computadoras</title>
	</head>
<jsp:useBean id="pc" scope="request" class="javabeans.Computadora" />
<jsp:setProperty name="pc" property="*"/>
<%if(request.getParameter("id")!=null && request.getParameter("id")!=""){%>
<jsp:forward page="../controladorpc?operacion=grabar"/>
<%}%>
<body>
<div>
  <h1>Agregar Computadora</h1>
  <form method="post">
  <br/><br/>
  <b>Datos de la Computadora</b><br/><br/>
  Introduzca Id:  <input type="number" name="id" required><br/>
  <br/>
  Marca:  <input type="text" name="marca"><br/>
  <br/>
  Procesador: <input type="text" name="procesador"><br/>
  <br/>
  Memoria: <input type="text" name="memoria"><br/>
  <br/>
  Disco: <textarea name="disco"></textarea><br/>
  <br/>
  Memoria de Video:  <input type="text" name="memoria_video"><br/>
  <br/>
  Descripci&oacute;n:  <input type="text" name="descripcion"><hr/><br/>
  <br/>

  <input type="submit" name="Submit" value="Guardar">
  <input type="reset" value="Reset">
  </form>
</div>
</body>
</html>
