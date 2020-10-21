package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Bombero;
import modelo.negocio.GestorListadoBomberos;

/**
 * Servlet implementation class ControladorBuscarBombero.
 * Se comunica con el HTML el form action="ControladorListadoBomberos"
 */
@WebServlet("/ControladorListadoBomberos")
public class ControladorListadoBomberos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//habria que comunicarse con la capa gestora dentro del modelo
		GestorListadoBomberos daoListadoBomberos= new GestorListadoBomberos();
				
		//ya que siempre quiero mostrar la lista de personas
		//se la pedimos al gestor y se la pasamos a la vista (jsp)
		List<Bombero> listaBombero = daoListadoBomberos.listar();
		request.setAttribute("listaBomberos", listaBombero);
		
		request.getRequestDispatcher("jsp/listadoBomberos.jsp").forward(request, response);
		
		response.getWriter().append("Served at: ").append("listaBomberos");
	}
				
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {						
		doGet(request, response);
	}
}
