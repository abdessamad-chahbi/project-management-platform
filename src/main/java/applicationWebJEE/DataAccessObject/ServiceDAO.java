package applicationWebJEE.DataAccessObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import applicationWebJEE.Connexion;
import applicationWebJEE.Models.ServiceModel;

public class ServiceDAO implements ServiceDAOInterface {
	private Connexion connexion;
	
	public ServiceDAO() {
		connexion = new Connexion();
	}
	
	@Override
	public List<ServiceModel> getServicesForDeveloppeur(int idEquipeDeve) {
	    List<ServiceModel> services = new ArrayList<>();
	    ResultSet res = null;
	    String req = "SELECT * FROM Service WHERE idEqDev = ? ";
	    try {
	        PreparedStatement st = connexion.getConnection().prepareStatement(req);
	        st.setInt(1, idEquipeDeve);
	          res = st.executeQuery();

	        while (res.next()) {
	            ServiceModel service = new ServiceModel();
	            service.setIdSer(res.getInt("idSer"));
	            service.setDescription(res.getString("description"));
	            service.setDureeSer(res.getInt("dureeSer"));

	            services.add(service);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return services;
	}

}
