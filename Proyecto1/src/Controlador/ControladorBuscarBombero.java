package Controlador;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Bombero;

/**
 * Servlet implementation class ControladorBuscarBombero
 * Se comunica con el HTML form action="ControladorBuscarBombero"
 */
@WebServlet("/ControladorBuscarBombero")
public class ControladorBuscarBombero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControladorBuscarBombero() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("idbombero");
		
		int iId = Integer.parseInt(id);
		
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("Proyecto1");
		EntityManager em = factoria.createEntityManager();
		
		Bombero b = em.find(Bombero.class, iId);
		if(b == null) {
			request.setAttribute("mensajeError", "El Idbombero numero: " + iId + " No existe,"+ " clicla en volver al formulario de Buscar");
		}else {
			request.setAttribute("mensaje1","<--- Bombero encontrado --->");
			request.setAttribute("mensaje2", "ID: " + b.getIdbombero()+
			"<br/>Categoria: " + b.getCategoria()+"<br/> Turno: " + b.getTurno()+"<br/>Nombre: " + b.getNombre()); 
		}
		System.out.println(b);
		
		/*habria que comunicarse con la capa gestora dentro del modelo, pero en este caso no lo hago
		lo dejo preparado po si algun dia lo necesito*/
		
				/*GestorBuscarBombero gb = new GestorBuscarBombero();	
			    gb.buscar(iId);*/
		
		request.getRequestDispatcher("jsp/buscarBombero.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
