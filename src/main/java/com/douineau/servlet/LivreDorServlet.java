package com.douineau.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douineau.dao.AvisDao;
import com.douineau.entity.Avis;

@WebServlet("/livre-d-or")
public class LivreDorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3085799964366932259L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LivreDorServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Avis> listAvis = AvisDao.getThreeLatestAvis();

// Setting the attribute of the request object 
// which will be later fetched by a JSP page 
		request.setAttribute("listAvis", listAvis);

// Creating a RequestDispatcher object to dispatch 
// the request the request to another resource 
		
		RequestDispatcher rd = request.getRequestDispatcher("livre-dor.jsp");

// The request will be forwarded to the resource  
// specified, here the resource is a JSP named, 
// "stdlist.jsp" 
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
