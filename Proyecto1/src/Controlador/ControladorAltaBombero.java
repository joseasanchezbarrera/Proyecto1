package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Bombero;
import modelo.negocio.GestorAltaBombero;

/**
 * Servlet implementation class ControladorAltaPersona.
 * se comunica con el HTML form action="altaBombero"
 */
@WebServlet("/altaBombero")
public class ControladorAltaBombero extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	//como el formulario hace un metodo post, entramos por aqui
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idbombero = request.getParameter("idbombero");
		String nombre = request.getParameter("nombre");
		String categoria = request.getParameter("categoria");
		String turno = request.getParameter("turno");
		
		int iIdbombero = Integer.parseInt(idbombero);
		int iTurno = Integer.parseInt(turno);
		
		Bombero b = new Bombero();
		b.setIdbombero(iIdbombero);
		b.setNombre(nombre);
				
		b.setCategoria(categoria);	
		b.setTurno(iTurno);
		
		//habria que comunicarse con la capa gestora dentro del modelo
		GestorAltaBombero gb = new GestorAltaBombero();
		int respuesta =gb.alta(b);
		
		//ya que siempre quiero mostrar la lista de personas
		//se la pedimos al gestor y se la pasamos a la vista (jsp)
		List<Bombero> listaBombero = gb.listar();
		request.setAttribute("listaBomberos", listaBombero);
		
		switch (respuesta) {
		case -1:
			//Como queremos avisar a la pagina que no se ha podido dar de alta
			//le podemos mandar mensajes, podemos mandar lo que sea
			//es una estructura de tipo hash que podremos recuperar en la parte de 
			//la vista(jsps)
			request.setAttribute("mensajeError", "El Nombre  tiene que tener más de 10 caracteres");
			
			//mediante requestDispatcher le decimos a donde queremos ir, es decir,
			//continuamos con la peticion http en otro recurso
			request.getRequestDispatcher("jsp/altaBombero.jsp").forward(request, response);
			break;
		case -2:
			//El idbombero no puede ser mayor de 10000
			request.setAttribute("mensajeError", "El idbombero tiene que ser menor de 10000");
			request.getRequestDispatcher("jsp/altaBombero.jsp").forward(request, response);
			break;	
		case -3:
			//La Categoria no puede estar vacia
			request.setAttribute("mensajeError", "La Categoria NO puede estar vacia");
			request.getRequestDispatcher("jsp/altaBombero.jsp").forward(request, response);
			break;
		case -4:
			//El Idbombero no puede estar vacio
			request.setAttribute("mensajeError", "El Idbombero NO puede estar vacio");
			request.getRequestDispatcher("jsp/altaBombero.jsp").forward(request, response);
			break;
		case -5:
			//El Turno no puede estar vacio
			request.setAttribute("mensajeError", "El Turno No puede estar vacio");
			request.getRequestDispatcher("jsp/altaBombero.jsp").forward(request, response);
			break;
		case -6:
			//El Idbombero Ya existe
			request.setAttribute("mensajeError", "El Idbombero numero: " + iIdbombero + " Ya existe");
			request.getRequestDispatcher("jsp/altaBombero.jsp").forward(request, response);
			break;
		default:
			// en caso de que se haya dado de alta
			request.setAttribute("mensaje", "Bombero dado de alta con ID: " + respuesta);
			request.getRequestDispatcher("jsp/altaBombero.jsp").forward(request, response);
			break;
		}	
	}
}



