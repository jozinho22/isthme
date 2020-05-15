package com.douineau.servlet.gestion;

import java.io.IOException;

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
//		Long count = AvisDao.getCount();
		HttpSession session = request.getSession();
		Long avisRestants = (Long) session.getAttribute("avisRestants");
		session.setAttribute("avisRestants", avisRestants);
		
		if(avisRestants.intValue() > 0) {
			Avis latestAvis = AvisDao.getLatestNotReadAvis();
			request.setAttribute("avis", latestAvis);
			session.setAttribute("index", 0);

			RequestDispatcher rd = request.getRequestDispatcher("gestion-avis.jsp");
			rd.forward(request, response);
		} 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
