package applicationWebJEE.DataAccessObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import applicationWebJEE.Connexion;
import applicationWebJEE.Models.UserModel;

public class UserDAO implements UserDAOInterface {
	private Connexion connexion;
	
	public UserDAO() {
		connexion = new Connexion();
	}
	
// La fonction d'authentification pour les trois Users (Directeur, ChefProjet, Developpeur)
	@Override
	public ResultSet authenticationUser(String login, String password, String role) {
		ResultSet res = null;
		String req = "SELECT * FROM Users WHERE login = ? AND password = ? AND role = ? ";
		try {
	        PreparedStatement st = connexion.getConnection().prepareStatement(req);
	        st.setString(1, login);  // Affecte la valeur de "login" au premier paramètre de la requête.
	        st.setString(2, password); // Affecte la valeur de "password" au deuxième paramètre de la requête.
	        st.setString(3, role);
	        res = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		      return res;
    }

// La fonction existence pour les trois Users (Directeur, ChefProjet, Developpeur)
	@Override
	public ResultSet UserExiste(String login, String role) {
		ResultSet res = null;
		// String req = "SELECT * FROM " + userType + " WHERE login = " + login;
		String req = "SELECT * FROM Users WHERE login = ? AND role = ? ";
		try {
			// Statement st=myCnx.createStatement();
			// res=st.executeQuery(req);
	        PreparedStatement st = connexion.getConnection().prepareStatement(req);
	        st.setString(1, login);
	        st.setString(2, role);
	        res = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		      return res;
	 }

// La fonction modifierPasswordUser pour les trois Users (Directeur, ChefProjet, Developpeur)
	@Override
	public void modifierPasswordUser(String login, String password, String role) {
		// String req = "UPDATE " + userType + " SET password = "+password+" WHERE login = "+ login;
		String req = "UPDATE Users SET password = ? WHERE login = ? AND role = ? ";
		try {
	        PreparedStatement st = connexion.getConnection().prepareStatement(req);
	        st.setString(1, password);
	        st.setString(2, login);
	        st.setString(3, role);
	        st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Override
	public List<UserModel> recupererTousChefProjets() {
		List<UserModel> chefProjets = new ArrayList<>();
		ResultSet res = null;
		String req = "SELECT * FROM Users WHERE role = ? ";	
		try {
	        PreparedStatement st = connexion.getConnection().prepareStatement(req);
	        st.setString(1, "chefProjet");
	        res = st.executeQuery();
	        
	        while (res.next()) {
	            UserModel chefProjet = new UserModel();
	            
	            chefProjet.setId(res.getInt("id"));
	            chefProjet.setNom(res.getString("nom"));
	            chefProjet.setPrenom(res.getString("prenom"));

	            chefProjets.add(chefProjet);
	        }
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		      return chefProjets;
	}
	
	public int getIdDirecteurByLogin(String login) throws SQLException {
	    int idDirecteur = 0;
	    String reqSQL = "SELECT id FROM Users WHERE login = ? AND role = 'directeur'";

	    try (PreparedStatement prSt = connexion.getConnection().prepareStatement(reqSQL)) {
	        prSt.setString(1, login);
	        try (ResultSet resultSet = prSt.executeQuery()) {
	            if (resultSet.next()) {
	                idDirecteur = resultSet.getInt("id");
	            }
	        }
	    }

	    return idDirecteur;
	}

	public UserModel getDirecteurById(int id) throws SQLException {
	    UserModel directeur = null;
	    String reqSQL = "SELECT nom, prenom FROM Users WHERE id = ? AND role = 'directeur'";

	    try (PreparedStatement prSt = connexion.getConnection().prepareStatement(reqSQL)) {
	        prSt.setInt(1, id);
	        try (ResultSet resultSet = prSt.executeQuery()) {
	            if (resultSet.next()) {
	                directeur = new UserModel();
	                directeur.setId(id);
	                directeur.setNom(resultSet.getString("nom"));
	                directeur.setPrenom(resultSet.getString("prenom"));
	            }
	        }
	    }

	    return directeur;
	}
	
	@Override
	public UserModel getDeveloppeurById(int identDev) {
	    UserModel developpeur = null;
	    String reqSQL = "SELECT * FROM Users WHERE id = ? AND role = 'developpeur'";
	    
	    try {
	        PreparedStatement prSt = connexion.getConnection().prepareStatement(reqSQL);
	          prSt.setInt(1, identDev);
	          ResultSet resultSet = prSt.executeQuery();
	       
	          if (resultSet.next()) {
	            	developpeur = new UserModel();
	            	developpeur.setId(identDev);
	            	developpeur.setNom(resultSet.getString("nom"));
	            	developpeur.setPrenom(resultSet.getString("prenom"));
	            	developpeur.setLogin(resultSet.getString("login"));
	            	developpeur.setPassword(resultSet.getString("password"));
	            }	          
		} catch (SQLException e) {
			e.printStackTrace();
		}

	    return developpeur;
	}
	
	@Override
	public int getIdDeveloppeurByLogin(String login) {
	    int idDeveloppeur = 0;
	    String reqSQL = "SELECT * FROM Users WHERE login = ? AND role = 'developpeur'";	    
	    try {
	        PreparedStatement prSt = connexion.getConnection().prepareStatement(reqSQL);
	          prSt.setString(1, login);
	          ResultSet resultSet = prSt.executeQuery();
	       
	          if (resultSet.next()) {
	        	  idDeveloppeur = resultSet.getInt("id");
	            }	          
		} catch (SQLException e) {
			e.printStackTrace();
		}

	    return idDeveloppeur;
	}

	@Override
	public void modifierProfilDeveloppeur(String nom, String prenom, String login, String password, int idDeve) {
		String req = "UPDATE Users SET nom = ?, prenom = ?, password = ?, login = ? WHERE id = ? ";
		try {
	        PreparedStatement st = connexion.getConnection().prepareStatement(req);
	        st.setString(1, nom);
	        st.setString(2, prenom);
	        st.setString(3, password);
	        st.setString(4, login);
	        st.setInt(5, idDeve);
	            st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
