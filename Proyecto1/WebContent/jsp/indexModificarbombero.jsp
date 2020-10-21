<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/estiloModificarbombero.css">
<script type="text/javascript" src="js/inicioCrud.js"></script>

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
<h1>Formulario Modificar Bombero</h1>
	<!-- El action sera el servlet(controlador) al que vamos a ir -->	
	<form name="funcion" action="ControladorModificarBombero" method="post">
	
    	Idbombero: <input type="number" readonly="readonly" name="idbombero" value=${bombero.idbombero}>
		<br/><br/>
		
		Categoria: <select name="categoria">
		<option value="${bombero.categoria}" selected="selected">${bombero.categoria}</option> 		
		<option value="BB">BB</option>
		<option value="BC">BC</option>
		<option value="EM">EM</option>
		<option value="SC">SC</option>	
		</select> 	
		<br/><br/>
		
	    Turno: <select name="turno">
	    <option value="${bombero.turno}">${bombero.turno}</option>	
		<option value=1>1</option>
		<option value=2>2</option>
		<option value=3>3</option>
		<option value=4>4</option>
		<option value=5>5</option>
		<option value=6>6</option>	
		</select>	
		<br/><br/>
			
		Nombre: <input type="text" name="nombre" value="${bombero.nombre}">
		<br/><br/>	
		
		<input id="modificar" class="boton" type="submit" value="modificar"/>
		<input id="Limpiar" class="boton" type="reset" value="Limpiar"/>
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