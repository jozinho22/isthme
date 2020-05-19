package com.douineau.servlet.gestion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestionServlet
 */
@WebServlet("/refuser-avis")
public class RefuserAvisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RefuserAvisServlet() {
		super();
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
	
//		String id = request.getParameter("id");
//		
//		AvisDao.delete(id);
//		
//		Long avisRestants = AvisDao.getCount();
//		HttpSession session = request.getSession();
//		session.setAttribute("avisRestants", avisRestants);
//		
//		Integer index = (Integer) session.getAttribute("index");
//		
//		if(avisRestants.intValue() > 0) {
//			Avis avis = AvisDao.getLatestNotReadAvis();
//			request.setAttribute("avis", avis);
//			
//			session.setAttribute("index", index - 1);
//			RequestDispatcher rd = request.getRequestDispatcher("gestion-avis.jsp");
//			rd.forward(request, response);
//		} else {
//			RequestDispatcher rd = request.getRequestDispatcher("gestion.jsp");
//			rd.forward(request, response);
//		}
		
	}

}
