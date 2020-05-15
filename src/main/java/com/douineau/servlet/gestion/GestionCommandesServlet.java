package com.douineau.servlet.gestion;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douineau.dao.ClientDao;
import com.douineau.dao.CommandeDao;
import com.douineau.entity.Client;
import com.douineau.entity.Commande;

/**
 * Servlet implementation class GestionServlet
 */
@WebServlet("/gestion-commandes")
public class GestionCommandesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionCommandesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = (String) request.getParameter("id");

		Client client = ClientDao.getClientById(id);
		List<Commande> commandes = CommandeDao.getCommandesClient(id);
		
		request.setAttribute("commandes", commandes);
		request.setAttribute("client", client);

		RequestDispatcher rd = request.getRequestDispatcher("gestion-commandes.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		Client client = ClientDao.getClientById(id);
		List<Commande> commandes = CommandeDao.getCommandesClient(id);
		
		System.out.println(client);
		System.out.println(commandes);
		
		request.setAttribute("commandes", commandes);
		request.setAttribute("client", client);

		RequestDispatcher rd = request.getRequestDispatcher("gestion-commandes.jsp");
		rd.forward(request, response);
	}

}
