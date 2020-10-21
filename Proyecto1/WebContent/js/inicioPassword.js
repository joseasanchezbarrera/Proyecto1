var contr;
var confContr;

function validar() {
	if(contr.value!=="" && confContr.value!=="") {
		if(contr.value!=confContr.value) {
			alertify.alert("Contraseñas distintas", "Pulsa la caja OK");
		}else {
			document.frm1.submit();
		}
	}else {
		alertify.alert("Contraseñas vacias", "Pulsa la caja OK");
	}
}

window.onload=function() {
	contr=document.frm1.contraseña;
	confContr=document.frm1.confContraseña;
	
	document.frm1.botonEnviar.addEventListener('click', validar);
    	
}