package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Bombero;
import modelo.negocio.GestorBajaBombero;

/**
 * Servlet implementation class ControladorBajaBombero.
 * Se comunica con HTML form name="formulariobaja" action="ControladorBajaBombero"
 */
@WebServlet("/ControladorBajaBombero")
public class ControladorBajaBombero extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idbombero = request.getParameter("idbombero");
		
		int iIdbombero = Integer.parseInt(idbombero);
		
		Bombero b = new Bombero();
		b.setIdbombero(iIdbombero);
		
		//habria que comunicarse con la capa gestora dentro del modelo
				GestorBajaBombero gb = new GestorBajaBombero();
				int respuesta = gb.baja(b);
					
		//ya que siempre quiero mostrar la lista de personas
		//se la pedimos al gestor y se la pasamos a la vista (jsp)
				List<Bombero> listaBombero = gb.listar();
				request.setAttribute("listaBomberos", listaBombero);
				
				switch (respuesta) {
				
					//Como queremos avisar a la pagina que no se ha podido dar de baja
					//le podemos mandar mensajes, podemos mandar lo que sea
					//es una estructura de tipo hash que podremos recuperar en la parte de 
					//la vista(jsps)
						
					//mediante requestDisptcher le decimos a donde queremos ir, es decir,
					//continuamos con la peticion http en otro recurso
					
				case -1:
					//caso idbombero mayor de 10000
					request.setAttribute("mensajeError", "El idbombero tiene que ser Menor de 10000");
					request.getRequestDispatcher("jsp/bajaBombero.jsp").forward(request, response);
					break;
				case -2:
					//El Idbombero no puede estar vacio
					request.setAttribute("mensajeError", "El Idbombero no puede estar vacio");
					request.getRequestDispatcher("jsp/bajaBombero.jsp").forward(request, response);
					break;
				case -3:
					//El Idbombero No existe
					request.setAttribute("mensajeError", "El Idbombero numero: " + iIdbombero + " No existe");
					request.getRequestDispatcher("jsp/bajaBombero.jsp").forward(request, response);
					break;
				default:
					// en caso de que se haya dado de alta
					request.setAttribute("mensaje", "Bombero dado de baja con ID: " + respuesta);
					request.getRequestDispatcher("jsp/bajaBombero.jsp").forward(request, response);
					break;
					
		}

	}

}
