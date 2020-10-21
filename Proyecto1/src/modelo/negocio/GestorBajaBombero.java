package modelo.negocio;

import java.util.List;

import modelo.entidad.Bombero;
import modelo.persistencia.DaoBajaBombero;

public class GestorBajaBombero {
	
	public int baja(Bombero b) {
		//esto serian reglas de negocio		
		
		if(b.getIdbombero() > 10000) {
			return -1;
		}
		
		if(b.getIdbombero() ==0) {
			return -2;
		} 
			
		//si llegamos a este punto, debemos de comunicarnos con la capa DAO
		DaoBajaBombero daobajaBombero = new DaoBajaBombero();
		if(daobajaBombero.existe(b.getIdbombero()) == -3)
			return -3;
		int id = daobajaBombero.eliminar(b);
			return id;	
				
		}

	public List<Bombero> listar(){
		//aqui podriamos poner reglas de negocio
		DaoBajaBombero daobajaBombero = new DaoBajaBombero();
		return daobajaBombero.listar();
	}	
	
}
