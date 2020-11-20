 package modelo.negocio;

import java.util.List;

import modelo.entidad.Bombero1;
import modelo.persistencia.DaoModificarFecha;

public class GestorModificarFecha {
	
	/*vamos a meter alguna regla de negocio, supongamos que me dice
	  que el nombre de la persona tiene que tener al menos 10 carateres
	  o que la categoria no puede estar vacia*/
	
			public  int modificar(Bombero1 b) {
				//esto serian reglas de negocio		
		
				if (b.getFecha() == null || b.getFecha().equals("")) {
					return -1;
				}
								
				//si llegamos a este punto, debemos de comunicarnos con la capa DAO
				DaoModificarFecha daoModificarFecha = new DaoModificarFecha();
					
				int id = daoModificarFecha.modificar(b);
				return id;
				
			}
			
			DaoModificarFecha daoModificarFecha = new DaoModificarFecha();
			public List<Bombero1> listar(){
				return daoModificarFecha.listar();
			}
										
		}
