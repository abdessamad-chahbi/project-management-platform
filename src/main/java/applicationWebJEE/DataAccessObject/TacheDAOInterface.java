package applicationWebJEE.DataAccessObject;

import java.util.List;

import applicationWebJEE.Models.TacheModel;

public interface TacheDAOInterface {
	
	public List<TacheModel> getAllTachesByService(int idServ); 
	public void updatePourcentage(int tacheId, double nouveauPourcentage);

}
