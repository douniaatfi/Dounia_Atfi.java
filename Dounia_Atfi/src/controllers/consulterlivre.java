package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Livre;
import sun.print.resources.serviceui_sv;

@WebServlet("/consulterlivre")
public class consulterlivre extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String nomauteur=request.getParameter("nom");
	    String nomcategorie=request.getParameter("nom");
	     
	    
		
		  try {
			Livre l=services.serviceLivre.lparcatauteur(nomauteur, nomcategorie);
		  if(l!=null) {
				out.print("mzyna");
			}else {
				out.print("mamzyna");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	}

