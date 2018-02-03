<html>
<head>
<title>envio</title>
</head>
<!--captura de datos e inserción en el Javabean-->
<!-- Instancia la clase esta es una forma y esta vivo mientras sea peticion request, envio y respuesta -->
<jsp:useBean id="contac" scope="request" class="javabeans.Contacto" />
<!--Son scripter deben ser pequeños y consisos-->
<jsp:setProperty name="contac" property="*"/>
<%if(request.getParameter("nombre")!=null){%>
   <jsp:forward page="controlador?operacion=grabar"/>
<%}%>
<body>
<center>
  <h1>Agregar nuevo Contacto</h1>
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

  <input type="submit" name="Submit" value="Guardar">
  <input type="reset" value="Reset">
  </form>
</center>
</body>
</html>
