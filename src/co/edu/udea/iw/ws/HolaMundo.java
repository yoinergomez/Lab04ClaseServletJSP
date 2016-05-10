package co.edu.udea.iw.ws;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


/**
 * Servicio web básico utilizando Jersey que cuenta
 * con métodos tres metodos saludar atraves del método GET
 * @author Yoiner Esteban Gomez Ayala yoiner.gomez22@gmail.com
 * @version 1.0
 */
@Path("Saludo")
public class HolaMundo {
	/**
	 * Link del servicio:
	 * http://localhost:8081/Lab04ClaseServletJSP/rest/Saludo
	*/
	
	
	/**
	 * Metodo GET que saluda al profesor con un hermoso mensaje
	 * http://localhost:8081/Lab04ClaseServletJSP/rest/Saludo/saludo
	 * @return
	 */
	@Path("saludo")
	@Produces(MediaType.TEXT_HTML)
	@GET
	public String saludar(){
		return "Buen día profesor. Todas las clases "
				+ "están debidamente documentadas";
	}
	
	
	/**
	 * Metodo GET que saluda al usuario con parametros query
	 * http://localhost:8081/Lab04ClaseServletJSP/rest/Saludo/saludo2?nombre=pepe
	 * @return
	 */
	@Path("saludo2")
	@Produces(MediaType.TEXT_HTML)
	@GET
	public String saludarparametros(@QueryParam("nombre") String nombreCompleto){
		return "Buen día "+nombreCompleto;
	}
	
	/**
	 * Metodo GET que saluda al usuario con parametros path
	 * http://localhost:8081/Lab04ClaseServletJSP/rest/Saludo/saludo3/pepe/perez
	 * @return
	 */
	@Path("saludo3/{nombre}/{apellido}")
	@Produces(MediaType.TEXT_HTML)
	@GET
	public String saludarparametros2(@PathParam("nombre") String nombreCompleto,
			@PathParam("apellido") String apellidoCompleto){
		return "Buen día "+nombreCompleto+" "+apellidoCompleto;
	}
	

}
