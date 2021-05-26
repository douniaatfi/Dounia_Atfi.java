package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controllers.Connexion;
import models.Livre;

public class daoLivre {
	public static ArrayList<Livre> listeLivres() throws SQLException, ClassNotFoundException{
		ArrayList<Livre> livres = new ArrayList<Livre>();
		Connexion.connect();
		ResultSet res = Connexion.select("select * from livre");
		while(res.next()) {
			Livre l =new Livre(res.getInt(1), res.getInt(2), res.getString(3),res.getString(4),res.getString(5),res.getInt(6),null, null);
			l.setCategorie(daoCategorie.categotirParId(res.getInt(7)));
			l.setAuteur(daoPersonne.PersonneParId(res.getInt(8)));
			livres.add(l);
		}
		Connexion.disconnect();
		return livres;
	}
	public static int AjouterLivre(Livre l) throws ClassNotFoundException, SQLException {
		int x=daoCategorie.getIdCatByName(l.getCategorie().getNom());
		int y=daoPersonne.getIdpersonneByName(l.getAuteur().getNom());
		
	
		Connexion.connect();
		int res = Connexion.Maj("INSERT INTO livre( isbn ,titre, genre, description, annee_edition,idcategorie,idauteur) VALUES ("+l.getIsbn()+",'"+l.getTitre()+"','"+l.getGenre()+"','"+l.getDescription()+"',"+l.getAnnee_edition()+","+x+","+y+")");
		Connexion.disconnect();
		return res;
	}
		
	public static boolean LivreExiste(int isbn) throws ClassNotFoundException, SQLException {
		boolean exist = false ;
		Connexion.connect();
		ResultSet res = Connexion.select("select * from livre where isbn="+isbn);
		if(res.next()) {
			exist=true;
		}
		Connexion.disconnect();
		return exist;
	}
	
	
	public static Livre livreparcatauteur(String nomauteur,String nomcat) throws ClassNotFoundException, SQLException {
		int x=daoPersonne.getIdpersonneByName(nomauteur);
		int y=daoCategorie.getIdCatByName(nomcat);
		Livre l=null;
		Connexion.connect();
		ResultSet res= Connexion.select("select * from livre where idcategorie="+y+" and idauteur="+x);
		if(res.next()){
		l=new Livre(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5),res.getInt(6),null,null);
		
		l.setCategorie(daoCategorie.categotirParId(res.getInt(7)));
		l.setAuteur(daoPersonne.PersonneParId(res.getInt(8)));}
         Connexion.disconnect();
		return  l;
		
	}
	
	
	
}
