package modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Bombero;

public class DaoBajaBombero {
	
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
	public int eliminar(Bombero b) {
		if(!abrirConexion()) {	
		return 0;
	}
		
		EntityTransaction et = em.getTransaction();
		et.begin();			
    //Así convierto la Entidad en Managed con merge(gestionada o manejada)//		
		b= em.merge(b);	
		em.remove(b);			
		et.commit();	
		cerrarConexion();			
	//una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
		return b.getIdbombero();
				
	}
	
	/*
	 *Creo el método existe y se comunica con el Gestor
	 * que es donde ponemos las reglas del negocio
	 */
	
	public int existe(int idbombero) {
		if(!abrirConexion()) {
			return 0;
		}
	
		Bombero b = em.find(Bombero.class, idbombero);
		if(b == null) {
			return -3;
		}else {
			return 1;
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


