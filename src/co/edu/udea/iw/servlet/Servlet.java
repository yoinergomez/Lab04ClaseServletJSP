package co.edu.udea.iw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Implementación del servlet Servlet que responde al método GET
 * @author Yoiner Esteban Gomez Ayala yoiner.gomez22@gmail.com
 * @version 1.0
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor de la clase
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Respuesta del método GET 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Constructor de respuesta
		PrintWriter out = response.getWriter();
		
		//Inserción de HTML
	    out.println("<html>");
	    out.println("<body>");
	    out.println("<h1>Hola Mundo</h1>");
	    out.println("<b>Este texto esta en negrita</b></br>");
	    out.println("</body>");
	    out.println("</html>");
	    
	}
}
