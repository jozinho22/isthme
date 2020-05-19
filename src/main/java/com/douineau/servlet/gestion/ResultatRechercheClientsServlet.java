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

import com.douineau.dao.ClientDao;
import com.douineau.entity.Client;

/**
 * Servlet implementation class GestionServlet
 */
@WebServlet("/resultat-recherche-clients")
public class ResultatRechercheClientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResultatRechercheClientsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String req = request.getParameter("req-recherche");
		
		List<Client> clients = ClientDao.getRechercheClient(req);
		
		HttpSession session = request.getSession();
		if(clients != null) {
			session.setAttribute("clients", clients);
			String size = String.valueOf(clients.size());
			request.setAttribute("size", size);
		}	
		
		RequestDispatcher rd = request.getRequestDispatcher("resultat-recherche-clients.jsp");
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
