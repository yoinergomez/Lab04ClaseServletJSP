package co.edu.udea.iw.ws;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Path;


/**
 * Servicio web básico utilizando Jersey, solo se implementa
 * un método para obtener un mensaje
 * @author Yoiner Esteban Gomez Ayala yoiner.gomez22@gmail.com
 * @version 1.0
 */
@Path("Saludo")
public class HolaMundo {
	
	/**
	 * Metodo GET que saluda al profesor con un hermoso mensaje
	 * @return
	 */
	/*
	@Produces(MediaType.TEXT_HTML)
	@GET
	public String saludar(){
		return "Buen día profesor. Todas las clases "
				+ "están debidamente documentadas";
	}
	*/
	
	/**
	 * Metodo GET que saluda al usuario con parametros
	 * @return
	 */
	@Produces(MediaType.TEXT_HTML)
	@GET
	public String saludar(@QueryParam("nombre") String nombreCompleto){
		return "Buen día "+nombreCompleto;
	}
}
