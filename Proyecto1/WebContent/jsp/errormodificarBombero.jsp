<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/EstiloJSP.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>  
<script type="text/javascript">
$(document).ready(function() {
	$('a').mouseover(function() {
		$('audio')[0].play();
	});
	$('a').mouseover(function() {
		$('color.green');
	});
});
</script> 

<title>Insert title here</title>
</head>
<body>

<h1>Base de Datos Listado Bomberos Parque 41</h1>
<a href="indexModificarbombero1.html">Volver al formulario de Modificar</a>
<br/>

<h1 style="color:red">${mensajeError}</h1>


<audio>
<source src="SonidoBoton.mp3" type="audio/mp3">
<source src="SonidoBoton.ogg" type="audio/ogg"> <!-- Audio solo para FireFox y Mozilla -->
</audio>

</body>
</html>