package com.douineau.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douineau.dao.AvisDao;
import com.douineau.entity.Avis;

@WebServlet("/ecrire")
public class EcrireServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3085799964366932259L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EcrireServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("ecrire.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String author = request.getParameter("author");
		String quote = request.getParameter("quote");

		Avis avis = new Avis();
		avis.setAuthor(author);
		avis.setQuote(quote);
		avis.setToValidate("1");
		avis.setCreatedAt(new Date());
		
		AvisDao.insertAvis(avis);

//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("confirmation-mail.jsp");    
//		requestDispatcher.forward(request, response);
		response.sendRedirect("index.jsp");
	}

}
