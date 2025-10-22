package applicationWebJEE.DataAccessObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import applicationWebJEE.Connexion;
import applicationWebJEE.Models.ProjetModel;
import applicationWebJEE.Models.ServiceModel;
import applicationWebJEE.Models.TacheModel;
import applicationWebJEE.Models.TechnologieModel;
import applicationWebJEE.Models.UserModel;

public class TechnologieDAO implements TechnologieDAOInterface {
	
	private Connexion connexion;
	
	public TechnologieDAO() {
		connexion = new Connexion();
	}
	
	@Override
	public List<TechnologieModel> getAllTechnologiesByDeveloppeur(int identDev) {
		 List<TechnologieModel> technologies = new ArrayList<>();
		    ResultSet res = null;
		    String req = "SELECT T.* FROM Technologie T, Competences_developpeur CD WHERE T.idTech=CD.idTech AND CD.idDev = ? ";
		    try {
		        PreparedStatement st = connexion.getConnection().prepareStatement(req);
		        st.setInt(1, identDev);
		          res = st.executeQuery();

		        while (res.next()) {
		        	TechnologieModel technologie = new TechnologieModel();
		        	technologie.setIdTech(res.getInt("idTech"));
		        	technologie.setNomTech(res.getString("nomTech"));       	

		        	 technologies.add(technologie);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		         return technologies;
	}
	
	// Les technologies que le développeur n'a pas maîtrisées
	@Override
	public List<TechnologieModel> getAllUnmasteredTechnologiesByDeveloppeur(int identDev) {
	    List<TechnologieModel> unmasteredTechnologies = new ArrayList<>();
	    ResultSet res = null;
	    String req = "SELECT T.* FROM Technologie T WHERE T.idTech NOT IN (SELECT CD.idTech FROM Competences_developpeur CD WHERE CD.idDev = ?)";
	    try {
	        PreparedStatement st = connexion.getConnection().prepareStatement(req);
	        st.setInt(1, identDev);
	        res = st.executeQuery();

	        while (res.next()) {
	            TechnologieModel technologie = new TechnologieModel();
	            technologie.setIdTech(res.getInt("idTech"));
	            technologie.setNomTech(res.getString("nomTech"));
	            unmasteredTechnologies.add(technologie);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return unmasteredTechnologies;
	}

	
	@Override
	public void ajouterTechnologie(int identDev, int identTech) {
	    String req = "INSERT INTO Competences_Developpeur (idDev, idTech) VALUES (?, ?) ";
	    try {
	        PreparedStatement prSt = connexion.getConnection().prepareStatement(req);
	        prSt.setInt(1, identDev);
	        prSt.setInt(2, identTech);
	          prSt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
// ------------- khaoula : ------------------------------------------------------
    public List<TechnologieModel> getAllTechnologies() {
        List<TechnologieModel> technologies = new ArrayList<>();

        String sql = "SELECT idTech, nomTech FROM technologie";

        try (PreparedStatement statement = connexion.getConnection().prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idTech = resultSet.getInt("idTech");
                String nomTech = resultSet.getString("nomTech");

                TechnologieModel technologie = new TechnologieModel(idTech, nomTech);
                technologies.add(technologie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return technologies;
    }

    @Override
    public List<TechnologieModel> getUsersByTechnologies(String[] technologies) {
        List<TechnologieModel> technologiesList = new ArrayList<>();
        String query = "SELECT technologie.nomTech, users.id, users.nom, users.prenom " +
                "FROM technologie " +
                "JOIN competences_developpeur ON technologie.idTech = competences_developpeur.idTech " +
                "JOIN users ON competences_developpeur.idDev = users.id " +
                "WHERE technologie.idTech = ?";
        try {
            PreparedStatement prst = connexion.getConnection().prepareStatement(query);
            for (String technology : technologies) {
                List<UserModel> usersList = new ArrayList<>();
                TechnologieModel techM=new TechnologieModel();
                prst.setString(1, technology);
                try {
                    ResultSet resultSet = prst.executeQuery();
                    while (resultSet.next()) {
                        techM.setNomTech(resultSet.getString("nomTech"));
                        int userId = resultSet.getInt("id");
                        String nom = resultSet.getString("nom");
                        String prenom = resultSet.getString("prenom");
                        UserModel user = new UserModel(userId, nom, prenom);
                        usersList.add(user);
                    }
                    techM.setIdTech(Integer.parseInt(technology));
                    techM.setUtilisateurs(usersList);
                    technologiesList.add(techM);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return technologiesList;
    }
}
