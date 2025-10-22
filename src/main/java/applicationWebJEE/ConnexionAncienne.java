package applicationWebJEE;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionAncienne {
	static Connection myCnx;
    private String pilote;
    private String URL = "jdbc:mysql://localhost:3306/myDataBase_gestion_projets";
    private String USER = "root";
    private String PASSWORD = "";

	public ConnexionAncienne() {
		try {
			pilote = new String("com.mysql.cj.jdbc.Driver");
			Class c = Class.forName(pilote);
			myCnx = DriverManager.getConnection(URL,USER,PASSWORD);
			} 
		catch(ClassNotFoundException e) {
				System.err.println("Erreur lors du chargement du pilote : " + e); 
			}
		 catch (SQLException e) {
			System.err.println("Erreur de syntaxe SQL :" + e);
		} 
	}

// On n'a pas besion de cette fonction connect() car deja declaree dans la fonction Connexion() 
	public void connect() throws SQLException {
		try {
			myCnx = DriverManager.getConnection(URL,USER,PASSWORD);		
		} catch (SQLException e) {
			System.err.println("Erreur de syntaxe SQL :" + e);
		} 		
	}
	
	public void disconnect() {
		try {
			myCnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
        return myCnx;
    }

// La fonction d'authentification pour les trois Users (Directeur, ChefProjet, Developpeur)
    public ResultSet authenticationUser(String login, String password, String userType) {
		ResultSet res = null;
		String req = "SELECT * FROM " + userType + " WHERE login = ? AND password = ?";
		try {
	        PreparedStatement st = myCnx.prepareStatement(req);
	        st.setString(1, login);  // Affecte la valeur de "login" au premier paramètre de la requête.
	        st.setString(2, password); // Affecte la valeur de "password" au deuxième paramètre de la requête.
	        res = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		      return res;
    }

// La fonction existence pour les trois Users (Directeur, ChefProjet, Developpeur)
	 public ResultSet UserExiste(String login, String userType) {
		ResultSet res = null;
		// String req = "SELECT * FROM " + userType + " WHERE login = " + login;
		String req = "SELECT * FROM " + userType + " WHERE login = ?";
		try {
			// Statement st=myCnx.createStatement();
			// res=st.executeQuery(req);
	        PreparedStatement st = myCnx.prepareStatement(req);
	        st.setString(1, login);
	        res = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		      return res;
	 }

// La fonction modifierPasswordUser pour les trois Users (Directeur, ChefProjet, Developpeur)
	public void modifierPasswordUser(String login, String password, String userType) {
		// String req = "UPDATE " + userType + " SET password = "+password+" WHERE login = "+ login;
		String req = "UPDATE " + userType + " SET password = ? WHERE login = ?";
		try {
	        PreparedStatement st = myCnx.prepareStatement(req);
	        st.setString(1, password);
	        st.setString(2, login);
	        st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	 

// La fonction ajouterProjet qui permet d'ajouter le projet dans la BD
	public int ajouterProjet(String nomProj, String description, String nomClient, String dateDem, String dateLiv, String nbJrsDev ) {
		String req = "INSERT INTO Projet (nomProj, description, clientProj, dateDem, dateLiv, nbJoursDev) VALUES (?, ?, ?, ?, ?, ?)";
		try {
	        PreparedStatement prSt = myCnx.prepareStatement(req);
	        prSt.setString(1, nomProj);
	        prSt.setString(2, description);
	        prSt.setString(3, nomClient);
	        prSt.setString(4, dateDem);
	        prSt.setString(5, dateLiv);
	        prSt.setString(6, nbJrsDev);        
		        int rowsInserted = prSt.executeUpdate();	        
		            return rowsInserted; 
		} catch (SQLException e) {
			e.printStackTrace();
			  return -1; // Ou une autre valeur d'erreur appropriée.
		}		
	}
	
// La fonction getAllDataProjets qui permet de retourner tous les donnees de la table Projet
	public ResultSet getAllDataProjets() {
	    ResultSet res = null;
	    String req = "SELECT * FROM Projet";
	    try {
	        PreparedStatement st = myCnx.prepareStatement(req);
	        res = st.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return res;
	}
	
// La fonction getProjetById qui permet de retourner le Projet par id Projet
	public ResultSet getProjetById(int identProjet) {
	    ResultSet res = null;
	    String req = "SELECT * FROM Projet WHERE idProj = ?";
	    try {
	        PreparedStatement st = myCnx.prepareStatement(req);
	        st.setInt(1, identProjet);
	        res = st.executeQuery();
	            return res;
	    } catch (SQLException e) {
	        e.printStackTrace();
	           return null;
	    }
	}

// La fonction getProjetById qui permet de verifier l'existence d'un projet par le nom du projet
	public boolean projetExistsByNom(String nomProjet, int idPrj) {
		ResultSet res = null;
	    String req = "SELECT COUNT(*) FROM Projet WHERE nomProj = ? AND idProj != ?";
	    try {
	        PreparedStatement st = myCnx.prepareStatement(req);
	        st.setString(1, nomProjet);
	        st.setInt(2, idPrj);
	        res = st.executeQuery();
            if (res.next()) {
                int count = res.getInt(1);
                return count > 0;
            }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
// La fonction updateProjetById qui permet de modifier les donnees de la table Projet par idProj
	public void updateProjetById(int idProjet, String nomProjet, String description, String client, String dateDemarrage, String dateLivraison, String nombreJours) {
	    String req = "UPDATE Projet SET nomProj=?, description=?, clientProj=?, dateDem=?, dateLiv=?, nbJoursDev=? WHERE idProj=?";;
	    try {
	        PreparedStatement st = myCnx.prepareStatement(req);
		        st.setString(1, nomProjet);
		        st.setString(2, description);
		        st.setString(3, client);
		        st.setString(4, dateDemarrage);
		        st.setString(5, dateLivraison);
		        st.setString(6, nombreJours);
		        st.setInt(7, idProjet);
	        	  st.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
// La fonction deleteProjectById qui permet supprimer le Projet par Id du projet
	public void deleteProjectById(int projectId) {
		String req = "DELETE FROM Projet WHERE idProj = ?";
	    try {
	        PreparedStatement st = myCnx.prepareStatement(req);
	        st.setInt(1, projectId);
	        st.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

//La fonction getPaginationDataProjets permet de récupérer les données depuis une base de données de manière paginée    
    public ResultSet getPaginationDataProjets(int startIndex, int itemsPerPage) {
        ResultSet resultSet = null;
        String reqSQL = "SELECT * FROM Projet LIMIT ?, ?";
       try {
        	PreparedStatement prSt = myCnx.prepareStatement(reqSQL);
        	prSt.setInt(1, startIndex);
        	prSt.setInt(2, itemsPerPage);
            resultSet = prSt.executeQuery();
                return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        } 
             return null;
    }
    
//La fonction rechercheProjetsParNom permet d'effectuer la recherche par nom de projet   
	public ResultSet rechercheProjetsParNom(String searchTerm) {
	    ResultSet resultSet = null;
	    String reqSQL = "SELECT * FROM Projet WHERE nomProj LIKE ?";
	   try {
	    	PreparedStatement prSt = myCnx.prepareStatement(reqSQL);
	    	  prSt.setString(1, "%" + searchTerm + "%");
	        resultSet = prSt.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	         return resultSet;
	}


	
}

