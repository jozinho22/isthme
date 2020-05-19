package com.douineau.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douineau.dao.ClientDao;
import com.douineau.dao.CommandeDao;
import com.douineau.entity.Client;
import com.douineau.entity.Commande;

@WebServlet("/inscription")
public class FormServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3085799964366932259L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormServlet() {
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
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String adresse = request.getParameter("adresse");
		String montantStr = request.getParameter("montant");
		Integer montant = Integer.parseInt(montantStr);

		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setEmail(email);
		client.setTel(tel);
		client.setAdresse(adresse);
		client.setNom(nom);
		client.setCreatedAt(new Date());

		ClientDao.insertClient(client);

		Commande commande = new Commande();
		commande.setMontant(montant);
		commande.setClient(client);
		commande.setCreatedAt(new Date());

		CommandeDao.insertCommande(commande);

//		MailService.sendMessage(subject, text, destinataire, copyDest);
		
		request.setAttribute("email", email);
		response.sendRedirect("index.jsp");
	}

}
