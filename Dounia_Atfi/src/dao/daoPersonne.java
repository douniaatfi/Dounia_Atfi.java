package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controllers.Connexion;
import models.Personne;
import models.Role;

public class daoPersonne {

        public static Personne PersonneParId(int id) throws ClassNotFoundException, SQLException {
		Personne p=null;
		Connexion.connect();
		ResultSet res=Connexion.select("select * from Personne where id="+id);
		if(res.next()) {
			p=new Personne(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), null);
			if(res.getString(6).equals("etudiant")) {
				p.setRole(Role.ETUDIANT);
			} else if(res.getString(6).equals("admin")) {
				p.setRole(Role.ADMIN);
			}else {
				p.setRole(Role.AUTEUR);
			}
			Connexion.disconnect();
			
		}
		return p;
	}
		
	
	
	public static int AjouterEtudiant(Personne p) throws ClassNotFoundException, SQLException {
		Connexion.connect();
		int res = Connexion.Maj("INSERT INTO `personne`(`nom`, `prenom`, `email`, `mdp`, `role`) VALUES ('"+p.getNom()+"','"+p.getPrenom()+"','"+p.getEmail()+"','"+p.getMdp()+"','etudiant')");
		Connexion.disconnect();
		return res;
	}
		
	public static boolean PersonneExiste(String email) throws ClassNotFoundException, SQLException {
		boolean exist = false ;
		Connexion.connect();
		ResultSet res = Connexion.select("select * from personne where email='"+email+"'");
		if(res.next()) {
			exist=true;
		}
		Connexion.disconnect();
		return exist;
	}
	
	public static Personne authentification(String login,String password) throws SQLException, ClassNotFoundException {
		ResultSet res = null;
		Personne p=null;
		Connexion.connect();
		res = Connexion.select("select * from personne where email='"+login+"' and mdp='"+password+"'");
		if(res.next()) {
			p=new Personne(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), null);
			if(res.getString(6).equals("etudiant")) {
				p.setRole(Role.ETUDIANT);
			} else if(res.getString(6).equals("admin")) {
				p.setRole(Role.ADMIN);
			}else {
				p.setRole(Role.AUTEUR);
			}
		}
		Connexion.disconnect();
		return p;
	}
	 public static int getIdpersonneByName(String name) throws ClassNotFoundException, SQLException {
			int idpersonne=0;
			Connexion.connect();
			ResultSet res = Connexion.select("select id from personne where nom='"+name+"'");
			if(res.next()) {
				idpersonne = res.getInt(1);
			}
			Connexion.disconnect();
			return idpersonne;
		}
	
	public static ArrayList<Personne> listeAuteurs() throws ClassNotFoundException, SQLException{
		ArrayList<Personne> personnes = new ArrayList<Personne>();
		Connexion.connect();
		ResultSet res = Connexion.select("select * from personne where role='auteur'");
		while(res.next()) {
			Personne p=new Personne(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), Role.AUTEUR);
			personnes.add(p);
		}
		Connexion.disconnect();
		return personnes;
	}
	
	
	
}
