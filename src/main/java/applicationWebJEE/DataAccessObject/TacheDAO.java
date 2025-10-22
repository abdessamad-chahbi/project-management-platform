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

public class TacheDAO implements TacheDAOInterface {

	private Connexion connexion;
	
	public TacheDAO() {
		connexion = new Connexion();
	}
	
	@Override
	public List<TacheModel> getAllTachesByService(int idServ){
		 List<TacheModel> taches = new ArrayList<>();
		    ResultSet res = null;
		    String req = "SELECT * FROM Tache WHERE idSer = ? ";
		    try {
		        PreparedStatement st = connexion.getConnection().prepareStatement(req);
		        st.setInt(1, idServ);
		          res = st.executeQuery();

		        while (res.next()) {
		        	TacheModel tache = new TacheModel();
		        	tache.setIdTache(res.getInt("idTache"));
		        	tache.setDescription(res.getString("description"));
		        	tache.setPourAvan(res.getDouble("pourAvan"));
		        	
		        	ServiceModel service = new ServiceModel();
		        	service.setIdSer(res.getInt("idSer"));	        	
		        	    tache.setService(service);

		            taches.add(tache);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return taches;
	}
	
// Méthode pour mettre à jour le pourcentage d'avancement dans la base de données
	@Override
    public void updatePourcentage(int tacheId, double nouveauPourcentage) {
	    String req = "UPDATE Tache SET pourAvan = ? WHERE idTache = ?";
	    try {
	        PreparedStatement st = connexion.getConnection().prepareStatement(req);
	          st.setDouble(1, nouveauPourcentage);
	          st.setInt(2, tacheId);
		        
	        	  st.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
