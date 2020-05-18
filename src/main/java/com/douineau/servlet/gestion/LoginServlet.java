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
import com.douineau.dao.GestionDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3085799964366932259L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if(GestionDao.check(login, password)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("session-login", login);
			
			Integer nbAvisRestants = AvisDao.getCount();
			session.setAttribute("nbAvisRestants", nbAvisRestants);
			
			RequestDispatcher rd = request.getRequestDispatcher("gestion.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
