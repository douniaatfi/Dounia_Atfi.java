package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Personne;
import services.servicePersonne;


@WebServlet("/inscription")
public class inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/inscription.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean res = false;
		PrintWriter out = response.getWriter();
		Personne p = new Personne(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("email"), request.getParameter("mdp"), null);
		 try {
			res = servicePersonne.AjouterPersonne(p);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(res) {
			 response.sendRedirect("http://localhost:8080/Dounia_Atfi/authentification");
		}else {
			response.sendRedirect("http://localhost:8080/Dounia_Atfi/inscription");
		}
		
	}

}
