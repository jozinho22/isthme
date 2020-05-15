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
@WebServlet("/valider-avis")
public class ValiderAvisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValiderAvisServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		AvisDao.validateAvis(id);
	
		Long avisRestants = AvisDao.getCount();
		HttpSession session = request.getSession();
		session.setAttribute("avisRestants", avisRestants);
		
		Integer index = (Integer) session.getAttribute("index");
		
		// S'il reste de avis en base
		if(avisRestants.intValue() > 0) {
			Avis avis = AvisDao.getLatestNotReadAvis();
			request.setAttribute("avis", avis);
			
			session.setAttribute("index", index - 1);
			RequestDispatcher rd = request.getRequestDispatcher("gestion-avis.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("gestion.jsp");
			rd.forward(request, response);
		}

	}

}
