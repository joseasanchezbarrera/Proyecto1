package Controlador;

import java.io.IOException;
import java.util.List;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Bombero1;
import modelo.negocio.GestorModificarFecha;

/**
 * Servlet implementation class ControladorModificarFecha.
 * Se comunica con el HTML form name="funcion" action="ControladorModificarFecha" pero en JSP no en HTML
 */
@WebServlet("/ControladorModificarFecha")
public class ControladorModificarFecha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @param em 
	 * @param id1 
	 * @throws ParseException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idbombero = request.getParameter("idbombero");
		String nombre = request.getParameter("nombre");
		String categoria = request.getParameter("categoria");
		String turno = request.getParameter("turno");
		String fecha = request.getParameter("fecha");
				
		int iIdbombero = Integer.parseInt(idbombero);
		int iTurno = Integer.parseInt(turno);
							
		Bombero1 b = new Bombero1();
		b.setIdbombero(iIdbombero);
		b.setNombre(nombre);
		
		System.out.println(nombre);
		b.setCategoria(categoria);
		b.setTurno(iTurno);
				
		b.setFecha(fecha);
		
		System.out.println(categoria);
		System.out.println(turno);
		
		//habria que comunicarse con la capa gestora dentro del modelo
		GestorModificarFecha gb = new GestorModificarFecha();
		int respuesta = gb.modificar(b);
				
		//ya que siempre quiero mostrar la lista de personas
		//se la pedimos al gestor y se la pasamos a la vista (jsp)
		
		List<Bombero1> listaBombero1 = gb.listar();
		request.setAttribute("listaBomberos1", listaBombero1);
		
		switch (respuesta) {
		case -1:
			//No se ha introducido ninguna fecha
			request.setAttribute("mensajeError", "No se ha introducido ninguna fecha");
			request.getRequestDispatcher("jspCubrir/modificarFecha.jsp").forward(request, response);
			break;
		case -2:
			//La fecha es la misma
			request.setAttribute("mensajeError", "La fecha "+fecha+" del Idbombero " +categoria+" "+idbombero+" es la misma, introducir una nueva");
			request.getRequestDispatcher("jspCubrir/modificarFecha.jsp").forward(request, response);
			break;
		default:
			// en caso de que se haya modificado
			request.setAttribute("mensaje1", "El Bombero con ID: "+b.getIdbombero());
			request.setAttribute("mensaje2", "Categoria: " + b.getCategoria()+", "+"Turno: " + b.getTurno()+"<br/>Nombre: " + b.getNombre()+
            "<br/>Ha sido modificado por la fecha: " + b.getFecha());
			request.getRequestDispatcher("jspCubrir/modificarFecha.jsp").forward(request, response);
			break;
		}	
			
	}
		
}
	
	
	
		
	
	

