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

	private static List<Avis> avisToCheck;
	
	private Integer nbAvisRestants;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionAvisServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (avisToCheck == null) {
			avisToCheck = AvisDao.get10LatestNotReadAvis();
		}
		
		nbAvisRestants = AvisDao.getCount();
		setAttributes(request);

		RequestDispatcher rd = request.getRequestDispatcher("gestion-avis.jsp");
		rd.forward(request, response);

	}

	private void setAttributes(HttpServletRequest request) {
		request.setAttribute("nbAvisRestants", nbAvisRestants);
		request.setAttribute("avis", avisToCheck.get(0));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		avisToCheck.remove(avisToCheck.get(0));
		nbAvisRestants -= 1 ;
		
		if (avisToCheck.size() == 0) {
			avisToCheck = AvisDao.get10LatestNotReadAvis();
			// S'il n'en reste plus
			if (avisToCheck.size() == 0) {
				request.setAttribute("nbAvisRestants", nbAvisRestants);
				RequestDispatcher rd = request.getRequestDispatcher("gestion.jsp");
				rd.forward(request, response);
			}
		}

		setAttributes(request);
		
		RequestDispatcher rd = request.getRequestDispatcher("gestion-avis.jsp");
		rd.forward(request, response);
	}

}
