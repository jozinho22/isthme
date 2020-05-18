package com.douineau.servlet.gestion;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douineau.dao.AvisDao;
import com.douineau.entity.Avis;

/**
 * Servlet implementation class GestionServlet
 */
@WebServlet("/gestion-avis")
public class GestionAvisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static List<Avis> avisRestants;

	private Integer index;
		/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionAvisServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(avisRestants == null) {
			avisRestants = AvisDao.get10LatestNotReadAvis();
			request.setAttribute("index", 0);
		}
		
		if("triAvis".equals(request.getAttribute("action"))) {
			index = (Integer) request.getAttribute("index");
			avisRestants.remove(avisRestants.get(index));
			request.setAttribute("index", index + 1);	
		} 

		if(avisRestants.size() == 0) {
			avisRestants = AvisDao.get10LatestNotReadAvis();
			//S'il n'en reste plus
			if(avisRestants.size() == 0) {
				request.removeAttribute("avisRestants");
				RequestDispatcher rd = request.getRequestDispatcher("gestion.jsp");
				rd.forward(request, response);
			} 
		}	
		
		request.setAttribute("nbAvisRestants", Integer.valueOf(avisRestants.size()));
		request.setAttribute("avisRestants", avisRestants);

		RequestDispatcher rd = request.getRequestDispatcher("gestion-avis.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
