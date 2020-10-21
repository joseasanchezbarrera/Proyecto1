package modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Bombero1;

public class DaoModificarFecha {

private EntityManager em;
	
	private boolean abrirConexion(){
		try {
			EntityManagerFactory factoria = Persistence.createEntityManagerFactory("Proyecto1");
			em = factoria.createEntityManager();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean cerrarConexion(){
		try {
			em.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * metodo que modifica en la bbdd un bombero  
	 * @return 0 en caso de que no haya conexion, el id en caso de que
	 * se haya modificado
	 */
	public int  modificar(Bombero1 b) {
		if(!abrirConexion()) {
			return 0;
		}
		
		/*merge sincroninza la bd con el objeto
		  tambien puede servir para dar de alta*/
				EntityTransaction et = em.getTransaction();								
					et.begin();		
				    b= em.merge(b);
					em.persist(b);
					et.commit();
					System.out.println(em.find(Bombero1.class, b.getIdbombero()));
					cerrarConexion();
							
				//una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
				System.out.println("a ver si sale " + b.getIdbombero() + " "+b.getNombre());
				return b.getIdbombero();
			}
	
	// Creo el metodo existe con el find para encontrar al bombero
	
	public int noExiste(int idbombero) {
		if(!abrirConexion()) {
			return 0;
		}
		Bombero1 b = em.find(Bombero1.class, idbombero);
		if(b == null) {
		return -6;
			}else {
				return 1;
				}
	}
			
			@SuppressWarnings("unchecked")
			public List<Bombero1> listar() {
				if(!abrirConexion()) {
					return null;
				}
				
				//para hacer la consulta debemos de usar JPQL
				Query query = em.createQuery("select b from Bombero1 b");
				List<Bombero1> listaBomberos1 = query.getResultList();
				return listaBomberos1;
			}
			
		}
