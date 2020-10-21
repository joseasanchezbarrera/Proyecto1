function baja() {
	
	var confirm = alertify.confirm('Baja del Bombero', 'Seguro que quiere darlo de Baja?',null, null).set('labels',{ok:'OK',cancel:'Cancelar'});		
		
	confirm.set('onok', function() {
		alertify.success('Has Confirmado'); 
		document.formulariobaja.submit();
	});
					
	confirm.set('oncancel',function() {
		alertify.error('Has Cancelado');	
	})	
   }
	   
window.onload = function () {
	document.formulariobaja.baja.addEventListener('click', baja);
}
///////////////////////////////////////////////////////////////////////////////////////
        // La clase de abajo salsrían las ventanas convencionales del navegador
/*function baja() {
	
	if(confirm('Seguro que quiere darlo de Baja?')) {
		document.formulariobaja.submit();
		alert('El Bombero se ha dado de baja o No existe'+'\n Click en Aceptar y espera a ver la siguiente pantalla');
	}else {
		document.formulariobaja.reset();
		alert('Operacion anulada'+'\n Click en Aceptar y espera a ver la siguiente pantalla');
	}
}

window.onload = function () {
	document.formulariobaja.baja.addEventListener('click', baja);
}*/


/////////////////////////////////////////////////////////////////////////////////////////////





