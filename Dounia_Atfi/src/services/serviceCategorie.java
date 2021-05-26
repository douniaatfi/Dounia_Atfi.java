package services;

import java.sql.SQLException;
import java.util.ArrayList;

import models.Categorie;

public class serviceCategorie {
	
   public static  ArrayList<Categorie> listeCategories() throws ClassNotFoundException, SQLException{
	   
	   return dao.daoCategorie.listeCategories();
   }
}
