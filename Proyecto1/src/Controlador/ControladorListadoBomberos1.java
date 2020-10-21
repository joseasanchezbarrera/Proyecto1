package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Bombero1;
import modelo.negocio.GestorListadoBomberos1;

/**
 * Servlet implementation class ControladorListadoBomberos1
 */
@WebServlet("/ControladorListadoBomberos1")
public class ControladorListadoBomberos1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//habria que comunicarse con la capa gestora dentro del modelo
				GestorListadoBomberos1 daoListadoBomberos= new GestorListadoBomberos1();
						
				//ya que siempre quiero mostrar la lista de personas
				//se la pedimos al gestor y se la pasamos a la vista (jsp)
				List<Bombero1> listaBombero1 = daoListadoBomberos.listar();
				request.setAttribute("listaBomberos1", listaBombero1);
				
				request.getRequestDispatcher("listadoBomberos1.jsp").forward(request, response);
				
				response.getWriter().append("Served at: ").append("listaBomberos1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
