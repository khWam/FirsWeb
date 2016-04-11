package fr.demos.web;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.data.ClimatisationDAO;
import fr.demos.data.FileClimatisationDAO;
import fr.demos.data.SQLClimatisationDAO;
import fr.demos.web.Climatisation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Servlet implementation class saisieClimatisationControleur
 */
@WebServlet("/saisieClimatisationControleur")
public class saisieClimatisationControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public saisieClimatisationControleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd=request.getRequestDispatcher("/saisieClimatisation.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		boolean errors=false;
		//request.setAttribute("erreurs", errors);
		RequestDispatcher rd=request.getRequestDispatcher("/saisieClimatisation.jsp");
		//	PrintWriter out = response.getWriter();
		//request.setCharacterEncoding("UTF-8");


		//Map<String, String[]> paramMap = request.getParameterNames();

		//out.println(paramMap.get("Submit")[1]);
		String subm = request.getParameter("Submit");
		if (subm!=null&& subm.equals("enregistrer")){
			String temperatureStr= request.getParameter("Temperature");
			String pressionStr=request.getParameter("Pression");
			String humiditeStr =request.getParameter("humidite");
			String nomAppareil = request.getParameter("nomAppareil");
			String DateStr = request.getParameter("Date");

			request.setAttribute("temper", temperatureStr);
			request.setAttribute("press", pressionStr);
			request.setAttribute("humidit", humiditeStr);
			request.setAttribute("Nom", nomAppareil);
			request.setAttribute("uneDate", DateStr);

			double temp=0; 
			double pres=0;
			int humid=0; 
			long date=0; 


			try{
				temp=Double.parseDouble(temperatureStr);
			}catch(NumberFormatException exp){
				errors =true;
				request.setAttribute("temperatureErreurs", "nombre incorrecte");

			}

			try{
				pres=Double.parseDouble(pressionStr);
			}catch(NumberFormatException exp){
				errors =true;
				request.setAttribute("pressionErreurs", "nombre incorrecte");

			}
			try{
				humid=Integer.parseInt(humiditeStr);
				if (humid<0){
					errors=true;
					request.setAttribute("humidSignErreurs", "humidite negative!");
				}
			}catch(NumberFormatException exp){
				errors =true;
				request.setAttribute("humiditeErreurs", "nombre incorrecte");

			}
			try{
				date=Long.parseLong(DateStr);
			}catch(NumberFormatException exp){
				errors =true;
				request.setAttribute("dateErreurs", "nombre incorrecte");

			}
			// validation
			if(nomAppareil==null||nomAppareil.equals("")){
				errors=true;
				request.setAttribute("appareilErreur", "nom d'appareil obligatoire");
			}

			if(!errors){
				Climatisation clim= new Climatisation(temp, pres, humid, nomAppareil, date);
				//ClimatisationDAO dao = new FileClimatisationDAO("climatisationFile");
				
				try {
					ClimatisationDAO dao;
					dao = new SQLClimatisationDAO("jdbc/appliclim");
					dao.sauve(clim);
				    rd=request.getRequestDispatcher("/successClimatisation.jsp");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					request.setAttribute("sauveErreur", e1.getMessage());
					rd=request.getRequestDispatcher("/saisieClimatisation.jsp");
				}
				

			} 

		}rd.forward(request, response);
	}
}
