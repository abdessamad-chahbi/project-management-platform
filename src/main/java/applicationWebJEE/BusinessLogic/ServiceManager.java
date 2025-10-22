package applicationWebJEE.BusinessLogic;

import java.util.List;

import applicationWebJEE.DataAccessObject.ServiceDAO;
import applicationWebJEE.Models.ServiceModel;

public class ServiceManager implements ServiceManagerInterface {
	private ServiceDAO serviceDAO;
	
	public ServiceManager() {
		serviceDAO = new ServiceDAO();
	}
	
	@Override
	public List<ServiceModel> getServicesForDeveloppeur(int idEquipeDeve) {
		 return serviceDAO.getServicesForDeveloppeur(idEquipeDeve);
	}

}
