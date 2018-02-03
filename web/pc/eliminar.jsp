<%--
    Document   : agregar
    Created on : 12-16-2017, 11:27:25 AM
    Author     : Gerardo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Eliminar Computadoras</title>
	</head>
<jsp:useBean id="pce" scope="request" class="javabeans.Computadora" />
<jsp:setProperty name="pce" property="*"/>
<%if(request.getParameter("id")!=null && request.getParameter("id")!=""){%>
   <jsp:forward page="../controladorpc?operacion=elimina"/>
<%}%>
<body>
<div>
  <h1>Eliminar Computadora</h1>
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
