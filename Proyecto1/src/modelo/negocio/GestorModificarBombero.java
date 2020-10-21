 package modelo.negocio;

import java.util.List;

import modelo.entidad.Bombero;
import modelo.persistencia.DaoModificarBombero;

public class GestorModificarBombero {
	
	/*vamos a meter alguna regla de negocio, supongamos que me dice
	  que el nombre de la persona tiene que tener al menos 10 carateres
	  o que la categoria no puede estar vacia*/
	
			//@SuppressWarnings("null")
			public  int modificar(Bombero b) {
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
				DaoModificarBombero daoModificarBombero = new DaoModificarBombero();
				if(daoModificarBombero.noExiste(b.getIdbombero()) == -6)
					return -6;

				int id = daoModificarBombero.modificar(b);
				return id;
			}
			
			DaoModificarBombero daoModificarBombero = new DaoModificarBombero();
			public List<Bombero> listar(){
				return daoModificarBombero.listar();
			}
										
		}
