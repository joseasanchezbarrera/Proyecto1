package modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Bombero;

public class DaoAltaBombero {

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
	 * metodo que inserta en la bbdd un bombero
	 * @param b el bombero a insertar
	 * @return 0 en caso de que no haya conexion, el id en caso de que
	 * se haya dado de alta
	 */
	public int alta(Bombero b) {
		if(!abrirConexion()) {
			return 0;
		}
		EntityTransaction et = em.getTransaction();
				et.begin();
				em.persist(b);    
				et.commit();
				cerrarConexion();				    		
		//una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
				return b.getIdbombero();
		}
	
	
	/**
	 * Este metodo lo hago por si un bombero no existe, find devuelve null y si no es que existe y 
	 * devuelve return -6 que lo tengo en el controlador de alta bombero en el switch
	 * @param idbombero
	 * @return
	 */
	public int existe(int idbombero) {
		if(!abrirConexion()) {
			return 0;
		}
		Bombero b = em.find(Bombero.class, idbombero);
		if(b == null) {
			return 1;
		}else {
			return -6;
		}
	}
	
		@SuppressWarnings("unchecked")
		public List<Bombero> listar() {
			if(!abrirConexion()) {
				return null;
		}
		
		//para hacer la consulta debemos de usar JPQL
		Query query = em.createQuery("select b from Bombero b");
		List<Bombero> listaBomberos = query.getResultList();
		return listaBomberos;
	}
	
}


