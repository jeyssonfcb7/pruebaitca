<%@ page import="javabeans.*,java.util.*"%>
<html>
    <head><title>Lista de Contactos</title></head>
<body>
<center>
<h1>Contactos</h1>
<%=(String)request.getAttribute("contactos")%>
<br/><br/>
<a href="inicio.htm">Inicio</a>
</center>
</body>
</html>