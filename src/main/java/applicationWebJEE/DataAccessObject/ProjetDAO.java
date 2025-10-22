package applicationWebJEE.DataAccessObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import applicationWebJEE.Connexion;
import applicationWebJEE.Models.ProjetModel;
import applicationWebJEE.Models.UserModel;

//Couche Persistance (DAO) : 
public class ProjetDAO implements ProjetDAOInterface{
	private Connexion connexion;
	
	public ProjetDAO() {
		connexion = new Connexion();
		// connexion.connect();
	}

// La fonction ajouterProjet qui permet d'ajouter le projet en utilisant le modele (ProjetModel )
	@Override
	public int ajouterProjet(ProjetModel projet) {
	    String req = "INSERT INTO Projet (nomProj, description, clientProj, dateDem, dateLiv, nbJoursDev) VALUES (?, ?, ?, ?, ?, ?)";
	    try {
	    	// PreparedStatement prSt = myCnx.prepareStatement(req);
	        PreparedStatement prSt = connexion.getConnection().prepareStatement(req);
	        prSt.setString(1, projet.getNomProj());
	        prSt.setString(2, projet.getDescription());
	        prSt.setString(3, projet.getClientProj());
	        prSt.setDate(4, projet.getDateDem());
	        prSt.setDate(5, projet.getDateLiv());
	        prSt.setInt(6, projet.getNbJoursDev());
	       // prSt.setString(7, projet.getMethodologie());
	       // prSt.setDate(8, projet.getDateReu());
	        int rowsInserted = prSt.executeUpdate();
	        return rowsInserted;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return -1; // Ou une autre valeur d'erreur appropriée.
	    }
	}

// La fonction getAllDataProjets qui permet de retourner tous les donnees de la table Projet
	@Override
	public List<ProjetModel> getAllDataProjets() {
	    List<ProjetModel> projets = new ArrayList<>();
	    ResultSet res = null;
	    String req = "SELECT * FROM Projet";
	    try {
	        PreparedStatement st = connexion.getConnection().prepareStatement(req);
	          res = st.executeQuery();

	        while (res.next()) {
	            ProjetModel projet = new ProjetModel();
	            projet.setIdProj(res.getInt("idProj"));
	            projet.setNomProj(res.getString("nomProj"));
	            projet.setDescription(res.getString("description"));
	            projet.setClientProj(res.getString("clientProj"));
	            projet.setDateDem(res.getDate("dateDem"));
	            projet.setDateLiv(res.getDate("dateLiv"));
	            projet.setNbJoursDev(res.getInt("nbJoursDev"));
	           // projet.setMethodologie(res.getString("methodologie"));
	           // projet.setDateReu(res.getDate("dateReu"));

	            projets.add(projet);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return projets;
	}
	
	// List<CompteModel> listeComptes = new ArrayList<>();
	// Map<Integer, CompteModel> mapComptes = new HashMap<>();

// La fonction getProjetById qui permet de retourner le Projet par id Projet
	@Override
	public ProjetModel getProjetById(int identProjet) {
		ProjetModel projet = null;
	    ResultSet res = null;
	    String req = "SELECT * FROM Projet WHERE idProj = ?";
	    try {
	        PreparedStatement st = connexion.getConnection().prepareStatement(req);
	        st.setInt(1, identProjet);
	        res = st.executeQuery();
	        if (res.next()) {
                projet = new ProjetModel();
                projet.setIdProj(res.getInt("idProj"));
	            projet.setNomProj(res.getString("nomProj"));
	            projet.setDescription(res.getString("description"));
	            projet.setClientProj(res.getString("clientProj"));
	            projet.setDateDem(res.getDate("dateDem"));
	            projet.setDateLiv(res.getDate("dateLiv"));
	            projet.setNbJoursDev(res.getInt("nbJoursDev"));
	           // projet.setMethodologie(res.getString("methodologie"));
	           // projet.setDateReu(res.getDate("dateReu"));
            }
              return projet;
	    } catch (SQLException e) {
	        e.printStackTrace();
	           return null;
	    }
	}

// La fonction projetExistsByNom qui permet de verifier l'existence d'un projet par le nom du projet
	@Override
	public boolean projetExistsByNom(String nomProjet, int idPrj) {
		ResultSet res = null;
	    String req = "SELECT COUNT(*) FROM Projet WHERE nomProj = ? AND idProj != ?";
	    try {
	        PreparedStatement st = connexion.getConnection().prepareStatement(req);
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
	@Override
	public void updateProjetById(ProjetModel projetModifie, int idProject) {
	    String req = "UPDATE Projet SET nomProj=?, description=?, clientProj=?, dateDem=?, dateLiv=?, nbJoursDev=? WHERE idProj=? ";
	    try {
	        PreparedStatement st = connexion.getConnection().prepareStatement(req);
		        st.setString(1, projetModifie.getNomProj());
		        st.setString(2, projetModifie.getDescription());
		        st.setString(3, projetModifie.getClientProj());
		        st.setDate(4, projetModifie.getDateDem());
		        st.setDate(5, projetModifie.getDateLiv());
		        st.setInt(6, projetModifie.getNbJoursDev());
		       // st.setString(7, projetModifie.getMethodologie());
		       // st.setDate(8, projetModifie.getDateReu());
		        st.setInt(7, idProject);
		        
	        	  st.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
// La fonction deleteProjectById qui permet supprimer le Projet par Id du projet
	@Override
	public void deleteProjectById(int projectId) {
		String req = "DELETE FROM Projet WHERE idProj = ?";
	    try {
	        PreparedStatement st = connexion.getConnection().prepareStatement(req);
	        st.setInt(1, projectId);
	        st.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

//La fonction getPaginationDataProjets permet de récupérer les données depuis une base de données de manière paginée    
	@Override
	public List<ProjetModel> getPaginationDataProjets(int startIndex, int itemsPerPage) {
		List<ProjetModel> projets = new ArrayList<>();
        ResultSet resultSet = null;
        String reqSQL = "SELECT * FROM Projet LIMIT ?, ?";
       try {
        	PreparedStatement prSt = connexion.getConnection().prepareStatement(reqSQL);
        	prSt.setInt(1, startIndex);
        	prSt.setInt(2, itemsPerPage);
            resultSet = prSt.executeQuery();
              //  return resultSet;
                
            while (resultSet.next()) {
                ProjetModel projet = new ProjetModel();
                projet.setIdProj(resultSet.getInt("idProj"));
                projet.setNomProj(resultSet.getString("nomProj"));
                projet.setDescription(resultSet.getString("description"));
                projet.setClientProj(resultSet.getString("clientProj"));
                projet.setDateDem(resultSet.getDate("dateDem"));
	            projet.setDateLiv(resultSet.getDate("dateLiv"));
	            projet.setNbJoursDev(resultSet.getInt("nbJoursDev"));
	          // projet.setMethodologie(resultSet.getString("methodologie"));
	          // projet.setDateReu(resultSet.getDate("dateReu"));

                projets.add(projet);
            }
               return projets;
                
        } catch (SQLException e) {
            e.printStackTrace();
        } 
             return null;
    }
    
//La fonction rechercheProjetsParNom permet d'effectuer la recherche par nom de projet   
    @Override
    public List<ProjetModel> rechercheProjetsParNom(String searchTerm) {
    	List<ProjetModel> projets = new ArrayList<>();
	    ResultSet resultSet = null;
	    String reqSQL = "SELECT * FROM Projet WHERE nomProj LIKE ?";
	   try {
	    	PreparedStatement prSt = connexion.getConnection().prepareStatement(reqSQL);
	    	  prSt.setString(1, "%" + searchTerm + "%");
	        resultSet = prSt.executeQuery();

	        while (resultSet.next()) {
	            ProjetModel projet = new ProjetModel();
	            projet.setIdProj(resultSet.getInt("idProj"));
	            projet.setNomProj(resultSet.getString("nomProj"));
	            projet.setDescription(resultSet.getString("description"));
	            projet.setClientProj(resultSet.getString("clientProj"));
	            projet.setDateDem(resultSet.getDate("dateDem"));
	            projet.setDateLiv(resultSet.getDate("dateLiv"));
	            projet.setNbJoursDev(resultSet.getInt("nbJoursDev"));
	           // projet.setMethodologie(resultSet.getString("methodologie"));
	           // projet.setDateReu(resultSet.getDate("dateReu"));

	            // Ajoutez le projet à la Map avec l'ID comme clé
	           // projets.put(projet.getIdProj(), projet);          
	            projets.add(projet);
	        }
	            return projets;
	            
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
    }
    
 // Méthode pour affecter un chef de projet à un projet
    @Override
    public void affecterChefProjet(int idProjet, int idChefProjet) {
	    String req = "UPDATE Projet SET idChefPrj = ? WHERE idProj = ? ";
	    try {
	        PreparedStatement st = connexion.getConnection().prepareStatement(req);
		        st.setInt(1, idChefProjet);
		        st.setInt(2, idProjet);
		        
	        	  st.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
    }
   
// Pour récupérer uniquement les projets avec un chef de projet assigné et qui sont deja affecte par un directeur donnee
    @Override
    public List<ProjetModel> getProjetsNonAffectes() {
        List<ProjetModel> projetsAffectes = new ArrayList<>();
        ResultSet resultSet = null;
	    String reqSQL = "SELECT * FROM Projet WHERE idChefPrj IS NULL";
	   // String reqSQL = "SELECT DISTINCT Prj.*, ChefPrj.nom, ChefPrj.prenom, Noti.message FROM Projet Prj, Users ChefPrj, Notification Noti WHERE Prj.idChefPrj = ChefPrj.id AND Noti.idDest = Prj.idChefPrj AND Prj.idChefPrj IS NOT NULL ";
	   /* String reqSQL = "SELECT DISTINCT Prj.*, ChefPrj.nom, ChefPrj.prenom, Noti.message " +
                "FROM Projet Prj " +
                "JOIN Users ChefPrj ON Prj.idChefPrj = ChefPrj.id " +
                "LEFT JOIN Notification Noti ON Prj.idProj = Noti.idProj " +
                "WHERE Prj.idChefPrj IS NOT NULL " +
                "AND Noti.idSour = ? "; */
        try {
        	PreparedStatement prSt = connexion.getConnection().prepareStatement(reqSQL);
        	
            resultSet = prSt.executeQuery();
                
            while (resultSet.next()) {
                ProjetModel projet = new ProjetModel();
                projet.setIdProj(resultSet.getInt("idProj"));
                projet.setNomProj(resultSet.getString("nomProj"));
                
//                UserModel chefProjet = new UserModel();
//	            chefProjet.setId(resultSet.getInt("idChefPrj"));
//	            chefProjet.setNom(resultSet.getString("nom"));
//	            chefProjet.setPrenom(resultSet.getString("prenom"));
//	            
//	            projet.setChefProjet(chefProjet);
	            

	            projetsAffectes.add(projet);
            }
               return projetsAffectes;
                
        } catch (SQLException e) {
            e.printStackTrace();
        } 
             return null;
    }

 // Vérifier si le projet a déjà un chef de projet
    @Override
    public boolean estProjetAffecte(int idProjet) {
    	ResultSet resultSet = null;
 	    String reqSQL = "SELECT * FROM Projet WHERE idChefPrj IS NOT NULL WHERE idProj = ?";	    
 	   try {
       	PreparedStatement prSt = connexion.getConnection().prepareStatement(reqSQL);
       	  prSt.setInt(1, idProjet);
           resultSet = prSt.executeQuery();    
           
           while (resultSet.next()) {
        	   return true;
           }
 	  } catch (SQLException e) {
          e.printStackTrace();
      } 
 	         return false;
    }
    
// -------------------------------------------------------------------------------
    @Override
    public List<ProjetModel> getProjetsDeveloppeurs(int idDeveppeur) {
        List<ProjetModel> projets = new ArrayList<>();
        ResultSet res = null;
        String req = "SELECT Prj.*, EqDev.idDevPrj FROM Projet Prj, Equipe_developpement EqDev WHERE Prj.idProj=EqDev.idPrj AND EqDev.idDev = ?";
        try {
            PreparedStatement st = connexion.getConnection().prepareStatement(req);
            st.setInt(1, idDeveppeur); 
            res = st.executeQuery();

            while (res.next()) {
                ProjetModel projet = new ProjetModel();
                projet.setIdProj(res.getInt("idDevPrj")); // L'id de developpeur (id de l'equipe de developpeur)
                projet.setNomProj(res.getString("nomProj"));
	            projet.setDescription(res.getString("description"));
	            projet.setClientProj(res.getString("clientProj"));
	            projet.setDateDem(res.getDate("dateDem"));
	            projet.setDateLiv(res.getDate("dateLiv"));
	            projet.setNbJoursDev(res.getInt("nbJoursDev"));
                
                projets.add(projet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projets;
    }
 
    
// ------------- khaoula : ------------------------------------------------------
	@Override
	public List<ProjetModel> getAllDataProjetsForChef(int chefId) {
		List<ProjetModel> projets = new ArrayList<>();
		ResultSet res = null;
		String req = "SELECT * FROM Projet WHERE idChefPrj = ?";
		try {
			PreparedStatement st = connexion.getConnection().prepareStatement(req);
			st.setInt(1, chefId);
			res = st.executeQuery();

			while (res.next()) {
				ProjetModel projet = new ProjetModel();
				projet.setIdProj(res.getInt("idProj"));
				projet.setNomProj(res.getString("nomProj"));
				projet.setDescription(res.getString("description"));
				projet.setClientProj(res.getString("clientProj"));
				projet.setDateDem(res.getDate("dateDem"));
				projet.setDateLiv(res.getDate("dateLiv"));
				projet.setNbJoursDev(res.getInt("nbJoursDev"));

				projets.add(projet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projets;
	}


	public void updateMethodologie(int idProjet, String nouvelleMethodologie){

		String updateQuery = "UPDATE projet SET methodologie = ? WHERE idProj = ?";
		try{
			PreparedStatement prst=connexion.getConnection().prepareStatement(updateQuery);
			prst.setString(1, nouvelleMethodologie);
			prst.setInt(2, idProjet);
			prst.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateDateReunion(int idPrj, String dateReunion){
		String requete="UPDATE projet SET dateReu = ? WHERE idProj = ?";
		try{
			PreparedStatement prst=connexion.getConnection().prepareStatement(requete);
			prst.setString(1,dateReunion);
			prst.setInt(2,idPrj);
			prst.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<String> nombreServiceProjet(int idChef){
		List<String> resultats = new ArrayList<>();
		String requete="SELECT projet.idProj, projet.nomProj, COUNT(service.idEqDev) as totalServices FROM projet LEFT JOIN equipe_developpement ON equipe_developpement.idPrj = projet.idProj LEFT JOIN service ON service.idEqDev = equipe_developpement.idDevPrj WHERE projet.idChefPrj = ? GROUP BY projet.idProj, projet.nomProj;";
		try{
			PreparedStatement prst=connexion.getConnection().prepareStatement(requete);
			prst.setInt(1,idChef);
			ResultSet resultSet = prst.executeQuery();
			while (resultSet.next()) {
				int idProj = resultSet.getInt("idProj");
				String nomProj = resultSet.getString("nomProj");
				int totalServices = resultSet.getInt("totalServices");

				String resultat = idProj + "-" + nomProj + "-" + totalServices;
				resultats.add(resultat);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return  resultats;
	}

	public List<String> servicesProjet(int idPrj){
		List<String> liste=new ArrayList<>();
		String req="SELECT service.idSer, service.description, service.dureeSer, CONCAT(users.nom, ' ', users.prenom) AS noms_dev FROM service JOIN equipe_developpement ON service.idEqDev = equipe_developpement.idDevPrj JOIN users ON equipe_developpement.idDev = users.id WHERE equipe_developpement.idPrj = ? GROUP BY service.idSer;";
		try{
			PreparedStatement prst=connexion.getConnection().prepareStatement(req);
			prst.setInt(1,idPrj);
			ResultSet resultSet=prst.executeQuery();
			while(resultSet.next()){
				int idSer=resultSet.getInt("idSer");
				String desc=resultSet.getString("description");
				int duree=resultSet.getInt("dureeSer");
				String devp=resultSet.getString("noms_dev");

				String resultat=idSer+"-"+desc+"-"+duree+"-"+devp;
				liste.add(resultat);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	@Override
	public List<String> getEquipeTechnologiesByProjetId(int idProject){
		List<String> resultats = new ArrayList<>();
		String requete="SELECT Dev.nom, Dev.prenom, Tech.nomTech FROM Equipe_Developpement EqDev, Users Dev, Technologie Tech WHERE Dev.id = EqDev.idDev AND EqDev.idTech = Tech.idTech AND EqDev.idPrj = ? ";
		try{
			PreparedStatement prst=connexion.getConnection().prepareStatement(requete);
			prst.setInt(1,idProject);
			ResultSet resultSet = prst.executeQuery();
			while (resultSet.next()) {
				String nomDev = resultSet.getString("nom");
				String prenomDev = resultSet.getString("prenom");
				String nomTech = resultSet.getString("nomTech");

				String resultat = nomDev + "-" + prenomDev + "-" + nomTech;
				resultats.add(resultat);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return  resultats;
	}
    
}
