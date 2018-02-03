<%--
    Document   : tablaWeb
    Created on : 12-16-2017, 11:20:18 AM
    Author     : Gerardo
--%>
<%@ page import="javabeans.*,java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><title>Lista de Computadoras</title></head>
<body>
<center>
<h1>Contactos</h1>
<%=(String)request.getAttribute("pcs")%>
<br/><br/>
<a href="index.html">Inicio</a>
</center>
</body>
</html>
