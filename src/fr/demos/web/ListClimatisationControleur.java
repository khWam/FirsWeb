package fr.demos.web;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.data.ClimatisationDAO;
import fr.demos.data.FileClimatisationDAO;
import fr.demos.web.Climatisation;

/**
 * Servlet implementation class ListClimatisationControleur
 */
@WebServlet("/ListClimatisationControleur")
public class ListClimatisationControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListClimatisationControleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("/listClimatisation.jsp");
		ArrayList<Climatisation> listClim;
		ClimatisationDAO dao = new FileClimatisationDAO("climatisationFile");
		listClim = new ArrayList<Climatisation>();
		
		//Climatisation clim=null;
		try{
			listClim= (ArrayList<Climatisation>) dao.rechercheTout() ;
			
		}catch(Exception e){request.setAttribute("erreurAffichage",e.getMessage());}

		
		request.setAttribute("listObjects", listClim);
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
