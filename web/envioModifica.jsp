<html>
<head>
<title>Modificar Contacto</title>
</head>
<!--captura de datos e inserción en el Javabean-->
<jsp:useBean id="contacto" scope="request" class="javabeans.Contacto" />
<jsp:setProperty name="contacto" property="*"/>
<%if(request.getParameter("nombre")!=null){%>
   <jsp:forward page="controlador?operacion=modifica"/>
<%}%>
<body>
<center>       
  <h1>Modificar Contacto</h1>
  <form method="post">
  <br/><br/>
  <b>Datos del Contacto:</b><br/><br/>
  Introduzca Id:  <input type="text" name="id"><br/>
  <br/>
  Introduzca Nombre:  <input type="text" name="nombre"><br/>
  <br/>
  Introduzca Apellido1: <input type="text" name="apellido1"><br/>
  <br/>
  Introduzca Apellido2: <input type="text" name="apellido2"><br/>
  <br/>
  Introduzca Direcci&oacute;n: <textarea name="direccion"></textarea><br/>
  <br/>
  Introduzca Tel&eacute;fono:  <input type="text" name="telefono"><br/>
  <br/>
  Introduzca Celular:  <input type="text" name="celular"><hr/><br/>
  <br/>
  Introduzca Email:  <input type="text" name="email"><hr/><br/>
  <br/>

  <input type="submit" name="Submit" value="Modificar">
  <input type="reset" value="Reset">
  </form>
</center>
</body>
</html>
