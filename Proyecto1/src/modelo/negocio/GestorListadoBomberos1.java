package modelo.negocio;

import java.util.List;

import modelo.entidad.Bombero1;
import modelo.persistencia.DaoListadoBomberos1;

public class GestorListadoBomberos1 {
	
	@SuppressWarnings("static-access")
	public List<Bombero1> listar(){
		//aqui podriamos poner reglas de negocio
		
		DaoListadoBomberos1 daoListadoBomberos = new DaoListadoBomberos1();
		return daoListadoBomberos.listar();
	}

}
