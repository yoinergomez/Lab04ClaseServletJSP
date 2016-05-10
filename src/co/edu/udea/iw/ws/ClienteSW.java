package co.edu.udea.iw.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.service.ClienteService;
import co.edu.udea.iw.ws.dto.ClienteSWDTO;
import javassist.tools.rmi.RemoteException;

/**
 * Servicio web básico utilizando la integración
 * de Jersey y Spring
 * @author Yoiner Esteban Gomez Ayala yoiner.gomez22@gmail.com
 * @version 1.0
 */
@Component
@Path("cliente")
public class ClienteSW {
	
	/**
	 * Link del servicio:
	 * http://localhost:8081/Lab04ClaseServletJSP/rest/cliente
	*/
	@Autowired
	private ClienteService clienteService;
	
	/**
	 * Obtiene todos los clientes de la BD y los lista
	 * @return
	 */
	@GET
	//@Produces(MediaType.APPLICATION_XML) //Retornar el resultado en formato XML
	@Produces(MediaType.APPLICATION_JSON) //Retornar el resultado en formato JSON
	public List<ClienteSWDTO> obtener() {
		List<ClienteSWDTO> lista = new ArrayList<>();
		try{
			for(Cliente cliente : clienteService.obtener()){
				ClienteSWDTO clienteSW = new ClienteSWDTO();
				clienteSW.setCedula(cliente.getCedula());
				clienteSW.setNombre(cliente.getNombres());
				clienteSW.setApellido(cliente.getApellidos());
				clienteSW.setEmail(cliente.getCorreoElectronico());
				
				lista.add(clienteSW);
			}
		} catch(IWDaoException e){
			throw new RemoteException(e);
		}
		return lista;
	}
}
