package modelo.negocio;

import java.util.List;

import modelo.entidad.Bombero;
import modelo.persistencia.DaoListadoBomberos;

public class GestorListadoBomberos {
	
	@SuppressWarnings("static-access")
	public List<Bombero> listar(){
		//aqui podriamos poner reglas de negocio
		
		DaoListadoBomberos daoListadoBomberos = new DaoListadoBomberos();
		return daoListadoBomberos.listar();
	}
}