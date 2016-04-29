package co.edu.udea.iw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.service.ClienteService;

/**
 * Implementación del servlet ClienteServlet que responde al método GET
 * @author Yoiner Esteban Gomez Ayala yoiner.gomez22@gmail.com
 * @version 1.0
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	
	//Declaración de variables
	private static final long serialVersionUID = 1L;
	private ClienteService clienteService = null;
       
    /**
     * Constructo del servlet
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Permite inicializar variables que perduran 
     * en el tiempo de vida del llamado del servlet
     */
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    	clienteService = (ClienteService) ac.getBean("clienteService");
    }

	/**
	 * Responde la petición GET con todos los clientes
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Constructor de respuesta
		PrintWriter out = response.getWriter();
				
		//Insertando HTML a la respuesta
		out.println("<html>");
	    out.println("<body>");
	    out.println("<h1>Clientes</h1>");
	    out.println("<b>Este texto esta en negrita</b></br>");
	    out.println("<table>");
	    out.println("<tr>");
	    out.println("<td>Cedula</td>");
	    out.println("<td>Nombre completo</td>");
	    out.println("<td>Correo</td>");
	    out.println("</tr>");
		
	    
		try {	
			List<Cliente> listaClientes = null;
			
			//Obteniendo los clientes
			listaClientes = clienteService.obtener();
			for(Cliente cliente:listaClientes){
				out.println("<tr>");
			    out.println("<td>"+cliente.getCedula()+"</td>");
			    out.println("<td>"+cliente.getNombres()+" "+cliente.getApellidos()+"</td>");
			    out.println("<td>"+cliente.getCorreoElectronico()+"</td>");
			    out.println("</tr>");
			}
		} catch (IWDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Cerrando etiquetas HTML
	    out.println("</table>");
	    out.println("</body>");
	    out.println("</html>");
	}

}
