<%@ page import="javabeans.*,java.util.*"%>
<html>
    <head><title>Lista de Contactos</title></head>
<body>
<center>
<h1>Contactos</h1>
<table border=1>
<tr><th>Id</th><th>Nombre</th><th>Apellido1</th><th>Apellido2</th><th>Direcci&oacute;n</th><th>Tel&eacute;fono</th><th>Celular</th><th>Email</th></tr>
<%boolean men=false;
ArrayList contactos=(ArrayList)request.getAttribute("contactos");
if(contactos!=null)
  //si existen mensajes para ese destinatario
  //se generará una tabla con los mismos
  for(int i=0;i<contactos.size();i++){
    Contacto m=(Contacto)contactos.get(i);
      men=true;%>
      <tr><td><%=m.getId()%></td><td><%=m.getNombre()%></td><td><%=m.getApellido1()%></td><td><%=m.getApellido2()%></td><td><%=m.getDireccion()%></td><td><%=m.getTelefono()%></td><td><%=m.getCelular()%></td><td><%=m.getEmail()%></td></tr>
    <%}
if(!men){%>
    <jsp:forward page="nomensajes.jsp"/>
<%}%>
</table>
<br/><br/>
<a href="inicio.htm">Inicio</a>
</center>
</body>
</html>