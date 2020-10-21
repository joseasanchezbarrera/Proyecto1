
function Alta() {
	document.formulario1.submit();
}

function Baja() {
	document.formulario2.submit();
}

function Buscar() {
	document.formulario3.submit();
}

function Cubrir24horas() {
	document.formulario4.submit();
}

function ListadoBomberos() {
	document.formulario5.submit();
}

function Modificar() {	
	document.formulario6.submit();
	
	}

function InicioCRUD() {
	document.formulario7.submit();
}

function setManejadorEventos() {
	document.formulario1.botonAlta.addEventListener("click", Alta);
	document.formulario2.botonBaja.addEventListener("click", Baja);
	document.formulario3.botonBuscar.addEventListener("click", Buscar);
	document.formulario4.botonCubrir24horas.addEventListener("click", Cubrir24horas);
	document.formulario5.botonListar.addEventListener("click", ListadoBomberos);
	document.formulario6.botonModificar.addEventListener("click", Modificar);	
	document.formulario7.botonInicioCRUD.addEventListener("click", InicioCRUD);	
}

window.onload=function() {
	setManejadorEventos();
}