package fr.demos.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.research.ws.wadl.Request;

/**
 * Servlet implementation class MaDate
 */
@WebServlet("/MaDateControleur")
public class MaDateControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaDateControleur() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// d representele modèle
		
		Date date = new Date();
		String laDate;
		String heure;
		String d;
		String h;
		
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat timeFormat= new SimpleDateFormat("'Il est 'HH' heures 'mm' minute'");
		
		laDate=dateFormat.format(date);
		heure =timeFormat.format(date);
		
		d= laDate;
	    h= heure;
		
	    Climatisation clim1 = new Climatisation(20, 50, 30, "Clim1", 2015);
	    
		//transfert du modèle
		request.setAttribute("dateDuJour", d);
		request.setAttribute("heureDuJour", h);
		request.setAttribute("Climatisation1", clim1);


		//appeler la vue
		RequestDispatcher rd = request.getRequestDispatcher("/madateView.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
