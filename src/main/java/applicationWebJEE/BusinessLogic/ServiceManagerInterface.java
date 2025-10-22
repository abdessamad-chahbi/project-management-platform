package applicationWebJEE.BusinessLogic;

import java.util.List;

import applicationWebJEE.Models.ServiceModel;

public interface ServiceManagerInterface {
	
	public List<ServiceModel> getServicesForDeveloppeur(int idEquipeDeve);

}
