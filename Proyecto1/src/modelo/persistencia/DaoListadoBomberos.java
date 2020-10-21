package modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Bombero;

@SuppressWarnings("unused")
public class DaoListadoBomberos {
	
	private static  EntityManager em;
	
	private static boolean abrirConexion(){
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
	public Bombero Listar(int id) {
		if(!abrirConexion()) {
			return null;
		}
		
		return em.find(Bombero.class, id);
						
	}
	@SuppressWarnings("unchecked")
	public static List<Bombero> listar() {
		if(!abrirConexion()) {
			return null;
		}		
		//para hacer la consulta debemos de usar JPQL
		Query query = em.createQuery("select b from Bombero b");
		List<Bombero> listaBomberos = query.getResultList();
		return listaBomberos;
	}	
}
