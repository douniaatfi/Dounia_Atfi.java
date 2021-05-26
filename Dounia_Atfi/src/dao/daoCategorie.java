package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controllers.Connexion;
import models.Categorie;

public class daoCategorie {
	public static Categorie categotirParId(int id) throws ClassNotFoundException, SQLException {
		Categorie c=null;
		Connexion.connect();
		ResultSet res = Connexion.select("select * from categorie where id="+id);
		if(res.next()) {
			c=new Categorie(res.getInt(1), res.getString(2), res.getString(3),null);
		}
		Connexion.disconnect();
		return c;
	}
	
	
	public static ArrayList<Categorie> listeCategories() throws SQLException, ClassNotFoundException{
		
		ArrayList<Categorie> categories = new ArrayList<Categorie>();
		Connexion.connect();
		ResultSet res = Connexion.select("select * from categorie");
		while(res.next()) {
			Categorie c=new Categorie(res.getInt(1), res.getString(2), res.getString(3), null);
			categories.add(c);
		}
		Connexion.disconnect();
		return categories;
	}
	public static int getIdCatByName(String name) throws ClassNotFoundException, SQLException {
		int idcat=0;
		Connexion.connect();
		ResultSet res = Connexion.select("select id from categorie where nom='"+name+"'");
		if(res.next()) {
			idcat = res.getInt(1);
		}
		Connexion.disconnect();
		return idcat;
	}
	public static String categnomparid(int id) throws ClassNotFoundException, SQLException {
		String cnom=null;
		Connexion.connect();
		ResultSet res = Connexion.select("select nom from categorie where id="+id);
		if(res.next()) {
			cnom= res.getString(2);
		}
		Connexion.disconnect();
		return cnom;
	}

}
