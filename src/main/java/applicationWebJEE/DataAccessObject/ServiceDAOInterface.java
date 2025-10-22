package applicationWebJEE.DataAccessObject;

import java.util.List;

import applicationWebJEE.Models.ServiceModel;

public interface ServiceDAOInterface {
	
	public List<ServiceModel> getServicesForDeveloppeur(int idEquipeDeve);

}
