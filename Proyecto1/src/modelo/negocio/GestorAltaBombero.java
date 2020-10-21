package modelo.negocio;

import java.util.List;

import modelo.entidad.Bombero;
import modelo.persistencia.DaoAltaBombero;

public class GestorAltaBombero {
	//aqui podriamos poner reglas de negocio
		
		/**
		 * Metodo que da de alta un Bombero
		 * @param b el Bombero a dar de alta
		 * @return -1 el idbombero tiene que ser menor de 10 caracteres, -2 el idbombero no puede
		 * ser mayor del numero 10000, -3 la categoria no puede estar vacia, -4 el idbombero no
		 * puede estar vacio, -5 el turno no puede estar vacio
		 */		
		
		public int alta(Bombero b) {
			//esto serian reglas de negocio
						
			if (b.getNombre().length() < 10) {
				return -1;
			}
			
			if(b.getIdbombero() > 10000){
				return -2;
			}
			
			if ( b.getCategoria().equals("0")) {
				return -3;
			}
			
			if (b.getIdbombero() ==0) {
				return -4;
			}
			
			if (b.getTurno() ==0) {
				return -5;				
			}
		
			//si llegamos a este punto, debemos de comunicarnos con la capa DAO
			DaoAltaBombero daoBombero = new DaoAltaBombero();
			if(daoBombero.existe(b.getIdbombero()) == -6)
				return -6;
			int id = daoBombero.alta(b);
				return id;
		}
		
		//aqui ponemos la lista de negocio
			DaoAltaBombero daoBombero = new DaoAltaBombero();
			public List<Bombero> listar(){
			return daoBombero.listar();
		}
									
	}



