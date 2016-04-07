

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

import fr.demos.Climatisation;

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
		ArrayList<Climatisation> listClim = new ArrayList<Climatisation>();
		//Climatisation clim=null;
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("climatisationFile")))){
			listClim= (ArrayList<Climatisation>) ois.readObject();
			
		}catch(IOException e){request.setAttribute("fichierObjectNotFoundException","fichierObjectNotFoundException");
		}catch(ClassNotFoundException exp){request.setAttribute("classNotFoundException",  "classNotFoundException");

		}
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
