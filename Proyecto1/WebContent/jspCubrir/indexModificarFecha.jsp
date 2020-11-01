<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="cssCubrir/indexModificarFecha.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('.boton').mouseover(function() {
		$('audio')[0].play();
	});
});
</script> 

<title>Insert title here</title>
</head>
<body>
<!-- Cambio de HTML a JSP para poder meter Java en este archivo -->
<h1>Formulario Modificar Fecha Cubrir 24 Horas</h1>


	<!-- El action sera el servlet(controlador) al que vamos a ir -->	
	<form name="funcion" action="ControladorModificarFecha" method="post">
	
    	Idbombero: <input type="number" readonly="readonly" name="idbombero" value="${bombero.idbombero}">
		<br/><br/>
		
		Categoria: <select name="categoria"> 
		<option value="${bombero.categoria}" selected="selected">${bombero.categoria}</option>
		<option disabled value="BB">BB</option>
		<option disabled value="BC">BC</option>
		<option disabled value="EM">EM</option>
		<option disabled value="SC">SC</option>	
		</select> 	
		<br/><br/>
		
	    Turno: <select name="turno">
	    <option value="${bombero.turno}" selected="selected">${bombero.turno}</option>	
		<option disabled value=1>1</option>
		<option disabled value=2>2</option>
		<option disabled value=3>3</option>
		<option disabled value=4>4</option>
		<option disabled value=5>5</option>
		<option disabled value=6>6</option>	
		</select>	
		<br/><br/>
			
		Nombre: <input type="text" readonly="readonly" name="nombre" size="45" value="${bombero.nombre}">
		<br/><br/>	
		
		Fecha: <input type="date" name="fecha" value="${bombero.fecha}">
		
		<input id="modificar" class="boton" type="submit" value="Modificar Fecha"/>
		<input id="Limpiar" class="boton" type="reset" value="Limpiar"/>
		<br/><br/>	
	</form>	
	
	<form action="ControladorListadoBomberos1" method="get">
<input id="ListadoBomberos" class="boton" type="submit" value="Listado Cubrir24horas"/>
<br/><br/>
</form>

<form action="InicioCRUD.html">
		<input id="InicioCRUD" class="boton" type="submit" value="InicioCRUD"/>
		<br/><br/>
		</form>
		
		<audio>
<source src="SonidoBoton.mp3" type="audio/mp3">
<source src="SonidoBoton.ogg" type="audio/ogg"> <!-- Audio solo para FireFox y Mozilla -->
</audio>
	
</body>
</html>