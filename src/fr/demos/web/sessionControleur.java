package fr.demos.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.research.ws.wadl.Request;

/**
 * Servlet implementation class sessionControleur
 */
@WebServlet("/sessionControleur")
public class sessionControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sessionControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("/sessionView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/sessionView.jsp");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String action = request.getParameter("Action");
		if(action!=null && action.equals("Connecter")){
			String pseudo = request.getParameter("Pseudo");
			pseudo =pseudo.trim();
			if(pseudo!=null && !pseudo.equals("")){
				//login ok
				session.setAttribute("pseudo", pseudo);
				rd=request.getRequestDispatcher("ListClimatisationControleur");
			}
			else{
				request.setAttribute("pseudoError", "pseudo obligatoire");
			}
		}
		rd.forward(request, response);
		
	}

}
