<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.co.sergio.mundo.vo.*"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
 
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crunchify JSP Servlet Example</title>
</head>
<body>
    <div align="center" style="margin-top: 50px;">
        <form action="CrunchifyServlet">
           Id Artista:  <input type="text" name="id" size="20px"> <br>
           usuario Artista:  <input type="text" name="usuario" size="20px"> <br><br>
           Nombre Artista:  <input type="text" name="nombre" size="20px"> <br><br>
           Apellido Artista:  <input type="text" name="apellido" size="20px"> <br><br>
           origen Artista:  <input type="text" name="origen" size="20px"> <br><br>
           Nombre Artista:  <input type="text" name="nombre" size="20px"> <br><br>
           Curriculum Artista:  <input type="text" name="curriculum" size="20px"> <br><br>
           Distincion Artista:  <input type="text" name="distincion" size="20px"> <br><br>
           Domicialiado Artista:  <input type="text" name="distincion" size="20px"> <br><br>
        <input type="submit" value="submit">
        </form>
     </div>
 
   
</body>
</html>
