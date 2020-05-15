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
@WebServlet("/next-avis")
public class NextAvisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NextAvisServlet() {
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
		Long avisRestants = AvisDao.getCount();
		HttpSession session = request.getSession();
		session.setAttribute("avisRestants", avisRestants);
		
		String nbStr = (String) request.getParameter("index");
		Integer index = Integer.parseInt(nbStr);
		
		System.out.println("index : " + (index + 1));
		System.out.println("avisRestants : " + avisRestants);

		Avis avis = AvisDao.getNextLatestNotReadAvis(index + 1);			
		request.setAttribute("avis", avis);
		session.setAttribute("index", index + 1);
		RequestDispatcher rd = request.getRequestDispatcher("gestion-avis.jsp");
		rd.forward(request, response);
		
	}

}
