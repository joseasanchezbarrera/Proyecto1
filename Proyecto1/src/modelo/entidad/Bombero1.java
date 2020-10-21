package modelo.entidad;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import modelo.negocio.GestorModificarFecha;

@SuppressWarnings("unused")
@Entity
//@Table(name= "bomberos")


public class Bombero1 {

	@Id
	private int idbombero;
	private String categoria;
	private int turno;
	private String nombre;
	private String fecha;
    
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdbombero() {
		return idbombero;
	}
	
	public void setIdbombero(int idbombero) {
		this.idbombero = idbombero;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Bombero [idbombero=" + idbombero + ", categoria=" + categoria + ",  turno=" + turno + ", nombre=" + nombre + ", fecha=" + fecha + " ]";
	}
				
}


