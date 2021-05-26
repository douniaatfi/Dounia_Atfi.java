package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Categorie;
import models.Livre;
import models.Personne;

import services.serviceLivre;


@SuppressWarnings("serial")
@WebServlet("/livre")
public class livre extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean res = false;
		PrintWriter out = response.getWriter();
		Livre l = new Livre(Integer.parseInt(request.getParameter("isbn")),request.getParameter("titre"), request.getParameter("genre"), request.getParameter("description"),Integer.parseInt(request.getParameter("annee_edition")),new Categorie(0, request.getParameter("nomcategorie"),null, null),new Personne (0,request.getParameter("nomauteur"),null, null,null,null));
		 try {
			res = serviceLivre.AjouterLivre(l);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(res) {
			out.print("Votre livre a été bien ajouté");
		}else {
			out.print("Votre ajoue a été echoué");
		}
	}

}