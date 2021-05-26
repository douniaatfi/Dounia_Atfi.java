package services;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.daoLivre;
import models.Livre;

public class serviceLivre {
    public static ArrayList<Livre> serviveLivres() throws ClassNotFoundException, SQLException {
    	
    	return dao.daoLivre.listeLivres();
    }
    public static boolean AjouterLivre(Livre l) throws ClassNotFoundException, SQLException {
		boolean exist = daoLivre.LivreExiste(l.getIsbn());
		if(exist) {
			return false;
		}else {
			int res = dao.daoLivre.AjouterLivre(l);
			return res == 1;
		}
	}
    public static Livre lparcatauteur(String nomauteur,String nomcat) throws ClassNotFoundException, SQLException {
    	return daoLivre.livreparcatauteur(nomauteur,nomcat);
    }
}
